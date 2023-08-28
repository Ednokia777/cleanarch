package com.siabul.cleanarch.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItemToList(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int): ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
    fun removeItemFromList(shopItem: ShopItem)
    fun updateShopItem(shopItem: ShopItem)

}