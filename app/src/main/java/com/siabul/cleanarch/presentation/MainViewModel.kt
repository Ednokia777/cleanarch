package com.siabul.cleanarch.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siabul.cleanarch.data.ShopListRepositoryImpl
import com.siabul.cleanarch.domain.GetShopListUseCase
import com.siabul.cleanarch.domain.RemoveItemFromListUseCase
import com.siabul.cleanarch.domain.ShopItem
import com.siabul.cleanarch.domain.UpdateShopItemUseCase

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeShopItemUseCase = RemoveItemFromListUseCase(repository)
    private val updateShopItemUseCase = UpdateShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun removeShopItem(shopItem: ShopItem) {
        removeShopItemUseCase.removeItemFromList(shopItem)
    }

    fun updateShopItem(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        updateShopItemUseCase.updateShopItem(newItem)
    }

}