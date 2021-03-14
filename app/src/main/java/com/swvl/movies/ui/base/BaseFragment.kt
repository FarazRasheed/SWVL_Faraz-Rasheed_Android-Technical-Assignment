package com.swvl.movies.ui.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.swvl.movies.BR
import dagger.android.support.DaggerFragment
import javax.inject.Inject

@Suppress("UNUSED_PARAMETER")
abstract class BaseFragment<T: ViewDataBinding, V: BaseViewModel> : DaggerFragment() {

    protected abstract val layoutId: Int
    var mActivity: BaseActivity<*, *>? = null

    abstract fun getViewModelClass(): Class<V>

    protected lateinit var binding: T
    protected var viewModel: V? = null
    private var mRootView: View? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var sp: SharedPreferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            val activity: BaseActivity<*, *> = context
            this.mActivity = activity
            activity.onFragmentAttached()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        if (!::binding.isInitialized) {
            binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
            mRootView = binding.root
//        }
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModelClass())
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }
}