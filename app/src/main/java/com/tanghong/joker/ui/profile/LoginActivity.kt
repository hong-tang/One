package com.tanghong.joker.ui.profile

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import com.tanghong.commonlibrary.base.BaseActivity
import com.tanghong.joker.R
import com.tanghong.joker.app.Constants
import http.ApiException
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import model.Account
import model.Result
import model.User
import org.jetbrains.anko.toast

/**
 * <pre>
 *     author : hasee
 *     time   : 2018/02/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class LoginActivity : BaseActivity<LoginPresenter>(), LoginContract.View, View.OnClickListener {

    override fun initPresenter(): LoginPresenter = LoginPresenter()

    override fun layoutId(): Int = R.layout.activity_login

    override fun initView() {
        presenter.attachView(this)
        toolBar.setTitle(R.string.title_login)
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn_clear_account.setOnClickListener(this)
        btn_clear_password.setOnClickListener(this)
        btn_password_state.setOnClickListener(this)
        btn_login.setOnClickListener(this)
        et_account.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        et_password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        toolBar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_clear_account -> {

            }
            R.id.btn_clear_password -> {

            }
            R.id.btn_password_state -> {

            }
            R.id.btn_login -> {
                if (TextUtils.isEmpty(et_account.toString().trim())) {
                    toast(R.string.prompt_intput_account)
                    return
                }
                if (TextUtils.isEmpty(et_password.toString().trim())) {
                    toast(R.string.prompt_input_password)
                    return
                }
                showProgress()
                presenter.login("***+****+${et_account.toString().substring(7)}",
                        Constants.sex, Constants.reg_type, Constants.uid)
            }
        }
    }

    override fun initData() {

    }

    override fun start() {

    }

    override fun login(result: Result<Account>) {
        presenter.loadUser(result.data.id, result.data.id, result.data.token)
    }

    override fun setUser(result: Result<User>) {
        finish()
    }

    override fun setError(e: ApiException) {
        closeProgress()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}