package de.lemona.android.guice.providers.system;

import com.google.inject.Inject;

import android.app.job.JobScheduler;
import android.content.Context;
import de.lemona.android.guice.ContextSingleton;

@ContextSingleton
public class JobSchedulerProvider extends AbstractServiceProvider<JobScheduler> {

    @Inject
    public JobSchedulerProvider(Context context) {
        super(Context.JOB_SCHEDULER_SERVICE, JobScheduler.class, context);
    }

}
