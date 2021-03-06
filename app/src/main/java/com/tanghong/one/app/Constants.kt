package com.tanghong.one.app

/**
 * <pre>
 *     author : hasee
 *     time   : 2018/01/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Constants private constructor() {

    companion object {

        //debug
        val DEBUG = true

        //http
        val baseUrl = "http://v3.wufazhuce.com:8000/api/"

        //config
        val platform = "android"
        val version = "4.5.1"
        val channel = "baidu"
        val sign = "a472875f55625efe726cdf7b73eae5ee"
        val uuid = "00000000-7a2a-fae7-9c35-fcea0033c587"
        val uid = "4398610029340"
        val sex = "0"
        val reg_type = "3"
        val city = "上海"

        //error
        //error code
        val error_code_request = -1
        val error_code_db = -2
        val error_code_empty = -3
        //error msg
        val error_msg_request = "request error"
        val error_msg_data = "data error"
        val error_msg_db_data = "db data error"
        val error_msg_empty = "data empty"

        val action_click = "com.tanghong.joker.action.CLICK"
    }
}