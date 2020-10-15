package com.example.farecare;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.google.android.gms.common.api.Api;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class RobotoCalendarView extends LinearLayout {
    private static final String DAY_OF_THE_MONTH_BACKGROUND = "dayOfTheMonthBackground";
    private static final String DAY_OF_THE_MONTH_CIRCLE_IMAGE_1 = "dayOfTheMonthCircleImage1";
    private static final String DAY_OF_THE_MONTH_CIRCLE_IMAGE_2 = "dayOfTheMonthCircleImage2";
    private static final String DAY_OF_THE_MONTH_LAYOUT = "dayOfTheMonthLayout";
    private static final String DAY_OF_THE_MONTH_TEXT = "dayOfTheMonthText";
    private static final String DAY_OF_THE_WEEK_LAYOUT = "dayOfTheWeekLayout";
    private static final String DAY_OF_THE_WEEK_TEXT = "dayOfTheWeekText";
    /* access modifiers changed from: private */
    @NonNull
    private Calendar currentCalendar = Calendar.getInstance();
    private TextView dateTitle;
    @Nullable
    private Calendar lastSelectedDayCalendar;
    private ImageView leftButton;
    private final OnClickListener onDayOfMonthClickListener = new OnClickListener() {
        public void onClick(View view) {
            String str = (String) ((ViewGroup) view).getTag();
            String substring = str.substring(RobotoCalendarView.DAY_OF_THE_MONTH_LAYOUT.length(), str.length());
            StringBuilder sb = new StringBuilder();
            sb.append(RobotoCalendarView.DAY_OF_THE_MONTH_TEXT);
            sb.append(substring);
            TextView textView = (TextView) view.findViewWithTag(sb.toString());
            Calendar instance = Calendar.getInstance();
            instance.set(1, RobotoCalendarView.this.currentCalendar.get(1));
            instance.set(2, RobotoCalendarView.this.currentCalendar.get(2));
            instance.set(5, Integer.valueOf(textView.getText().toString()).intValue());
            RobotoCalendarView.this.markDayAsSelectedDay(instance.getTime());
            if (RobotoCalendarView.this.robotoCalendarListener != null) {
                RobotoCalendarView.this.robotoCalendarListener.onDayClick(instance.getTime());
                return;
            }
            throw new IllegalStateException("You must assign a valid RobotoCalendarListener first!");
        }
    };
    private final OnLongClickListener onDayOfMonthLongClickListener = new OnLongClickListener() {
        public boolean onLongClick(View view) {
            String str = (String) ((ViewGroup) view).getTag();
            String substring = str.substring(RobotoCalendarView.DAY_OF_THE_MONTH_LAYOUT.length(), str.length());
            StringBuilder sb = new StringBuilder();
            sb.append(RobotoCalendarView.DAY_OF_THE_MONTH_TEXT);
            sb.append(substring);
            TextView textView = (TextView) view.findViewWithTag(sb.toString());
            Calendar instance = Calendar.getInstance();
            instance.set(1, RobotoCalendarView.this.currentCalendar.get(1));
            instance.set(2, RobotoCalendarView.this.currentCalendar.get(2));
            instance.set(5, Integer.valueOf(textView.getText().toString()).intValue());
            RobotoCalendarView.this.markDayAsSelectedDay(instance.getTime());
            if (RobotoCalendarView.this.robotoCalendarListener != null) {
                RobotoCalendarView.this.robotoCalendarListener.onDayLongClick(instance.getTime());
                return true;
            }
            throw new IllegalStateException("You must assign a valid RobotoCalendarListener first!");
        }
    };
    private ImageView rightButton;
    /* access modifiers changed from: private */
    private RobotoCalendarListener robotoCalendarListener;
    private ViewGroup robotoCalendarMonthLayout;
    private View rootView;
    private boolean shortWeekDays = false;

    public interface RobotoCalendarListener {
        void onDayClick(Date date);

        void onDayLongClick(Date date);

        void onLeftButtonClick();

        void onRightButtonClick();
    }

    public RobotoCalendarView(Context context) {
        super(context);
        init(null);
    }

    public RobotoCalendarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public RobotoCalendarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    @RequiresApi(api = 21)
    public RobotoCalendarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet);
    }

    private static String checkSpecificLocales(String str, int i) {
        if (i != 4 || !"ES".equals(Locale.getDefault().getCountry())) {
            return str.substring(0, 1).toUpperCase();
        }
        return "X";
    }

    private static int getDayIndexByDate(Calendar calendar) {
        return calendar.get(5) + getMonthOffset(calendar);
    }

    private static int getMonthOffset(Calendar calendar) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(calendar.getTime());
        instance.set(5, 1);
        int firstDayOfWeek = instance.getFirstDayOfWeek();
        int i = instance.get(7);
        if (firstDayOfWeek == 1) {
            return i - 1;
        }
        if (i == 1) {
            return 6;
        }
        return i - 2;
    }

    private static int getWeekIndex(int i, Calendar calendar) {
        if (calendar.getFirstDayOfWeek() == 1) {
            return i;
        }
        if (i == 1) {
            return 7;
        }
        return i - 1;
    }

    private static boolean areInTheSameDay(@NonNull Calendar calendar, @NonNull Calendar calendar2) {
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        if (!isInEditMode()) {
            this.rootView = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.roboto_calendar_view_layout, this, true);
            findViewsById(this.rootView);
            setUpEventListeners();
            this.currentCalendar = Calendar.getInstance();
            setDate(this.currentCalendar.getTime());
            ViewPump.init(ViewPump.builder().addInterceptor(new CalligraphyInterceptor(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf").setFontAttrId(R.attr.fontPath).build())).build());
        }
    }

    public void setDate(@NonNull Date date) {
        this.currentCalendar.setTime(date);
        updateView();
    }

    @NonNull
    public Date getDate() {
        return this.currentCalendar.getTime();
    }

    @Nullable
    public Date getSelectedDay() {
        return this.lastSelectedDayCalendar.getTime();
    }

    public void markDayAsSelectedDay(@NonNull Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        clearSelectedDay();
        this.lastSelectedDayCalendar = instance;
        getDayOfMonthBackground(instance).setBackgroundResource(R.drawable.circle);
        getDayOfMonthText(instance).setTextColor(ContextCompat.getColor(getContext(), R.color.roboto_calendar_selected_day_font));
        ImageView circleImage1 = getCircleImage1(instance);
        ImageView circleImage2 = getCircleImage2(instance);
        if (circleImage1.getVisibility() == View.VISIBLE) {
            DrawableCompat.setTint(circleImage1.getDrawable(), ContextCompat.getColor(getContext(), R.color.roboto_calendar_selected_day_font));
        }
        if (circleImage2.getVisibility() == View.VISIBLE) {
            DrawableCompat.setTint(circleImage2.getDrawable(), ContextCompat.getColor(getContext(), R.color.roboto_calendar_selected_day_font));
        }
    }

    public void clearSelectedDay() {
        if (this.lastSelectedDayCalendar != null) {
            ViewGroup dayOfMonthBackground = getDayOfMonthBackground(this.lastSelectedDayCalendar);
            Calendar instance = Calendar.getInstance();
            if (instance.get(1) == this.lastSelectedDayCalendar.get(1) && instance.get(6) == this.lastSelectedDayCalendar.get(6)) {
                dayOfMonthBackground.setBackgroundResource(R.drawable.ring);
            } else {
                dayOfMonthBackground.setBackgroundResource((int) 17170445);
            }
            getDayOfMonthText(this.lastSelectedDayCalendar).setTextColor(ContextCompat.getColor(getContext(),R.color.roboto_calendar_day_of_the_month_font));
            ImageView circleImage1 = getCircleImage1(this.lastSelectedDayCalendar);
            ImageView circleImage2 = getCircleImage2(this.lastSelectedDayCalendar);
            if (circleImage1.getVisibility() == View.VISIBLE) {
                DrawableCompat.setTint(circleImage1.getDrawable(), ContextCompat.getColor(getContext(),R.color.roboto_calendar_circle_1));
            }
            if (circleImage2.getVisibility() == View.VISIBLE) {
                DrawableCompat.setTint(circleImage2.getDrawable(), ContextCompat.getColor(getContext(),R.color.roboto_calendar_circle_2));
            }
        }
    }

    public void setShortWeekDays(boolean z) {
        this.shortWeekDays = z;
    }

    public void markCircleImage1(@NonNull Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        ImageView circleImage1 = getCircleImage1(instance);
        circleImage1.setVisibility(VISIBLE);
        if (this.lastSelectedDayCalendar == null || !areInTheSameDay(instance, this.lastSelectedDayCalendar)) {
            DrawableCompat.setTint(circleImage1.getDrawable(), ContextCompat.getColor(getContext(), R.color.roboto_calendar_circle_1));
        } else {
            DrawableCompat.setTint(circleImage1.getDrawable(), ContextCompat.getColor(getContext(), R.color.roboto_calendar_selected_day_font));
        }
    }

    public void markCircleImage2(@NonNull Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        ImageView circleImage2 = getCircleImage2(instance);
        circleImage2.setVisibility(VISIBLE);
        if (this.lastSelectedDayCalendar == null || !areInTheSameDay(instance, this.lastSelectedDayCalendar)) {
            DrawableCompat.setTint(circleImage2.getDrawable(), ContextCompat.getColor(getContext(), R.color.roboto_calendar_circle_2));
        } else {
            DrawableCompat.setTint(circleImage2.getDrawable(), ContextCompat.getColor(getContext(), R.color.roboto_calendar_selected_day_font));
        }
    }

    public void showDateTitle(boolean z) {
        if (z) {
            this.robotoCalendarMonthLayout.setVisibility(VISIBLE);
        } else {
            this.robotoCalendarMonthLayout.setVisibility(GONE);
        }
    }

    public void setRobotoCalendarListener(RobotoCalendarListener robotoCalendarListener2) {
        this.robotoCalendarListener = robotoCalendarListener2;
    }

    private void findViewsById(View view) {
        this.robotoCalendarMonthLayout = (ViewGroup) view.findViewById(R.id.robotoCalendarDateTitleContainer);
        this.leftButton = (ImageView) view.findViewById(R.id.leftButton);
        this.rightButton = (ImageView) view.findViewById(R.id.rightButton);
        this.dateTitle = (TextView) view.findViewById(R.id.monthText);
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int i = 0;
        while (i < 42) {
            int i2 = (i % 7) + 1;
            StringBuilder sb = new StringBuilder();
            sb.append(DAY_OF_THE_WEEK_LAYOUT);
            sb.append(i2);
            ViewGroup viewGroup = (ViewGroup) view.findViewWithTag(sb.toString());
            View inflate = layoutInflater.inflate(R.layout.roboto_calendar_day_of_the_month_layout, null);
            View findViewWithTag = inflate.findViewWithTag(DAY_OF_THE_MONTH_TEXT);
            View findViewWithTag2 = inflate.findViewWithTag(DAY_OF_THE_MONTH_BACKGROUND);
            View findViewWithTag3 = inflate.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_1);
            View findViewWithTag4 = inflate.findViewWithTag(DAY_OF_THE_MONTH_CIRCLE_IMAGE_2);
            i++;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DAY_OF_THE_MONTH_LAYOUT);
            sb2.append(i);
            inflate.setTag(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(DAY_OF_THE_MONTH_TEXT);
            sb3.append(i);
            findViewWithTag.setTag(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(DAY_OF_THE_MONTH_BACKGROUND);
            sb4.append(i);
            findViewWithTag2.setTag(sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(DAY_OF_THE_MONTH_CIRCLE_IMAGE_1);
            sb5.append(i);
            findViewWithTag3.setTag(sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(DAY_OF_THE_MONTH_CIRCLE_IMAGE_2);
            sb6.append(i);
            findViewWithTag4.setTag(sb6.toString());
            viewGroup.addView(inflate);
        }
    }

    private void setUpEventListeners() {
        this.leftButton.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                RobotoCalendarView.lambda$setUpEventListeners$0(RobotoCalendarView.this, view);
            }
        });
        this.rightButton.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                RobotoCalendarView.lambda$setUpEventListeners$1(RobotoCalendarView.this, view);
            }
        });
    }

    public static /* synthetic */ void lambda$setUpEventListeners$0(RobotoCalendarView robotoCalendarView, View view) {
        if (robotoCalendarView.robotoCalendarListener != null) {
            robotoCalendarView.currentCalendar.add(2, -1);
            robotoCalendarView.lastSelectedDayCalendar = null;
            robotoCalendarView.updateView();
            robotoCalendarView.robotoCalendarListener.onLeftButtonClick();
            return;
        }
        throw new IllegalStateException("You must assign a valid RobotoCalendarListener first!");
    }

    public static /* synthetic */ void lambda$setUpEventListeners$1(RobotoCalendarView robotoCalendarView, View view) {
        if (robotoCalendarView.robotoCalendarListener != null) {
            robotoCalendarView.currentCalendar.add(2, 1);
            robotoCalendarView.lastSelectedDayCalendar = null;
            robotoCalendarView.updateView();
            robotoCalendarView.robotoCalendarListener.onRightButtonClick();
            return;
        }
        throw new IllegalStateException("You must assign a valid RobotoCalendarListener first!");
    }

    private void setUpMonthLayout() {
        String str = new DateFormatSymbols(Locale.getDefault()).getMonths()[this.currentCalendar.get(2)];
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, 1).toUpperCase());
        sb.append(str.subSequence(1, str.length()));
        String sb2 = sb.toString();
        if (this.currentCalendar.get(1) == Calendar.getInstance().get(1)) {
            this.dateTitle.setText(sb2);
            return;
        }
        this.dateTitle.setText(String.format("%s %s", new Object[]{sb2, Integer.valueOf(this.currentCalendar.get(1))}));
    }

    private void setUpWeekDaysLayout() {
        String str;
        String[] weekdays = new DateFormatSymbols(Locale.getDefault()).getWeekdays();
        int length = weekdays.length;
        for (int i = 1; i < length; i++) {
            View view = this.rootView;
            StringBuilder sb = new StringBuilder();
            sb.append(DAY_OF_THE_WEEK_TEXT);
            sb.append(getWeekIndex(i, this.currentCalendar));
            TextView textView = (TextView) view.findViewWithTag(sb.toString());
            String str2 = weekdays[i];
            if (this.shortWeekDays) {
                str = checkSpecificLocales(str2, i);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2.substring(0, 1).toUpperCase());
                sb2.append(str2.substring(1, 3));
                str = sb2.toString();
            }
            textView.setText(str);
        }
    }

    @SuppressLint("ResourceType")
    private void setUpDaysOfMonthLayout() {
        for (int i = 1; i < 43; i++) {
            View view = this.rootView;
            StringBuilder sb = new StringBuilder();
            sb.append(DAY_OF_THE_MONTH_LAYOUT);
            sb.append(i);
            ViewGroup viewGroup = (ViewGroup) view.findViewWithTag(sb.toString());
            View view2 = this.rootView;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DAY_OF_THE_MONTH_BACKGROUND);
            sb2.append(i);
            ViewGroup viewGroup2 = (ViewGroup) view2.findViewWithTag(sb2.toString());
            View view3 = this.rootView;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(DAY_OF_THE_MONTH_TEXT);
            sb3.append(i);
            TextView textView = (TextView) view3.findViewWithTag(sb3.toString());
            View view4 = this.rootView;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(DAY_OF_THE_MONTH_CIRCLE_IMAGE_1);
            sb4.append(i);
            View findViewWithTag = view4.findViewWithTag(sb4.toString());
            View view5 = this.rootView;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(DAY_OF_THE_MONTH_CIRCLE_IMAGE_2);
            sb5.append(i);
            View findViewWithTag2 = view5.findViewWithTag(sb5.toString());
            textView.setVisibility(INVISIBLE);
            findViewWithTag.setVisibility(GONE);
            findViewWithTag2.setVisibility(GONE);
            textView.setBackgroundResource(17170445);
            textView.setTypeface(null, Typeface.NORMAL);
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.roboto_calendar_day_of_the_month_font));
            viewGroup.setBackgroundResource( 17170445);
            viewGroup.setOnClickListener(null);
            viewGroup2.setBackgroundResource( 17170445);
        }
    }

    private void setUpDaysInCalendar() {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTime(this.currentCalendar.getTime());
        int i = 1;
        instance.set(5, 1);
        int weekIndex = getWeekIndex(instance.get(7), instance);
        while (i <= instance.getActualMaximum(5)) {
            View view = this.rootView;
            StringBuilder sb = new StringBuilder();
            sb.append(DAY_OF_THE_MONTH_LAYOUT);
            sb.append(weekIndex);
            ViewGroup viewGroup = (ViewGroup) view.findViewWithTag(sb.toString());
            View view2 = this.rootView;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DAY_OF_THE_MONTH_TEXT);
            sb2.append(weekIndex);
            TextView textView = (TextView) view2.findViewWithTag(sb2.toString());
            if (textView == null) {
                break;
            }
            viewGroup.setOnClickListener(this.onDayOfMonthClickListener);
            viewGroup.setOnLongClickListener(this.onDayOfMonthLongClickListener);
            textView.setVisibility(VISIBLE);
            textView.setText(String.valueOf(i));
            i++;
            weekIndex++;
        }
        for (int i2 = 36; i2 < 43; i2++) {
            View view3 = this.rootView;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(DAY_OF_THE_MONTH_TEXT);
            sb3.append(i2);
            TextView textView2 = (TextView) view3.findViewWithTag(sb3.toString());
            View view4 = this.rootView;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(DAY_OF_THE_MONTH_LAYOUT);
            sb4.append(i2);
            ViewGroup viewGroup2 = (ViewGroup) view4.findViewWithTag(sb4.toString());
            if (textView2.getVisibility() == INVISIBLE) {
                viewGroup2.setVisibility(GONE);
            } else {
                viewGroup2.setVisibility(VISIBLE);
            }
        }
    }

    private void markDayAsCurrentDay() {
        Calendar instance = Calendar.getInstance();
        if (instance.get(1) == this.currentCalendar.get(1) && instance.get(2) == this.currentCalendar.get(2)) {
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(instance.getTime());
            getDayOfMonthBackground(instance2).setBackgroundResource(R.drawable.ring);
        }
    }

    private void updateView() {
        setUpMonthLayout();
        setUpWeekDaysLayout();
        setUpDaysOfMonthLayout();
        setUpDaysInCalendar();
        markDayAsCurrentDay();
    }

    private ViewGroup getDayOfMonthBackground(Calendar calendar) {
        return (ViewGroup) getView(DAY_OF_THE_MONTH_BACKGROUND, calendar);
    }

    private TextView getDayOfMonthText(Calendar calendar) {
        return (TextView) getView(DAY_OF_THE_MONTH_TEXT, calendar);
    }

    private ImageView getCircleImage1(Calendar calendar) {
        return (ImageView) getView(DAY_OF_THE_MONTH_CIRCLE_IMAGE_1, calendar);
    }

    private ImageView getCircleImage2(Calendar calendar) {
        return (ImageView) getView(DAY_OF_THE_MONTH_CIRCLE_IMAGE_2, calendar);
    }

    private View getView(String str, Calendar calendar) {
        int dayIndexByDate = getDayIndexByDate(calendar);
        View view = this.rootView;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(dayIndexByDate);
        return view.findViewWithTag(sb.toString());
    }
}

