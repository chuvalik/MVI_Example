package com.example.mvieducationalexample.core.redux

interface Reducer<S : State, A : Action> {

    suspend fun reduce(currentState: S, action: A): S
}