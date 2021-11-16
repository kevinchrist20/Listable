package com.kevinchrist.listable

import com.billkainkoom.ogya.quicklist.Listable
import com.billkainkoom.ogya.quicklist.ListableType

data class Setting(
    val icon: Int,
    val title: String
) : Listable() {
    override fun getListableType(): ListableType? {
        return ListableTypes.setting
    }
}
