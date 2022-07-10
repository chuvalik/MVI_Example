package com.example.mvieducationalexample.core.redux

import android.util.Log

private const val LOGGING_TAG = "LoggingMiddleware"

class LoggingMiddleware<S : State, A : Action> : Middleware<S, A> {
    override suspend fun process(action: A, currentState: S, store: Store<S, A>) {
        Log.d(
            LOGGING_TAG,
            "Processing action: $action, Current state: $currentState"
        )
    }
}