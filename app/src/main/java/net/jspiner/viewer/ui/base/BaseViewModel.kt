package net.jspiner.viewer.ui.base

import android.support.annotation.CallSuper
import io.reactivex.subjects.CompletableSubject
import net.jspiner.viewer.util.LifecycleTransformer

abstract class BaseViewModel {

    private val lifecycleSubject: CompletableSubject by lazy { CompletableSubject.create() }

    protected fun <T> bindLifecycle(): LifecycleTransformer<T> {
        return LifecycleTransformer(lifecycleSubject)
    }

    @CallSuper
    open fun onDestroy() {
        lifecycleSubject.onComplete()
    }
}