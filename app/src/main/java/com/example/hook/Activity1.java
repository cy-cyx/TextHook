package com.example.hook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 简单的Hook例子
 */
public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 替换mInstrumentation
        try {
            Field field = Activity.class.getDeclaredField("mInstrumentation");
            field.setAccessible(true);
            Instrumentation instrumentation = (Instrumentation) field.get(this);
            InstrumentationProxy proxy = new InstrumentationProxy(instrumentation);
            field.set(this, proxy);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        startActivity(new Intent(this, Activity_empty.class));
    }

    public class InstrumentationProxy extends Instrumentation {

        Instrumentation inner;

        public InstrumentationProxy(Instrumentation inner) {
            this.inner = inner;
        }

//        @Override
        public ActivityResult execStartActivity(
                Context who, IBinder contextThread, IBinder token, Activity target,
                Intent intent, int requestCode, Bundle options) {
            Log.d("xx", "execStartActivity: 代理");
            try {
                @SuppressLint("PrivateApi")
                Method method = Instrumentation.class.getDeclaredMethod("execStartActivity",
                        Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, int.class,
                        Bundle.class);
                return (ActivityResult) method.invoke(inner, who, contextThread, token, target, intent, requestCode, options);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
