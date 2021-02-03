package com.example.freon.b647012serv;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class LittleJobService extends JobService {
    public static final String TAG = "LittleJobService";
    private boolean jobCanceled = false;

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "");
        Log.d(TAG, "onStartJob");
        doBackgroundWork(jobParameters);

        return true;
    }

    private void doBackgroundWork(JobParameters jobParameters){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    Log.d(TAG,"run: " + i);
                    if (jobCanceled){
                        return;
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Log.d(TAG, "Job finished");
                    jobFinished(jobParameters, false);
                }
            }
        }).start();

    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "Job cancelled before completion");
        jobCanceled = true;
        return true;
    }
}
