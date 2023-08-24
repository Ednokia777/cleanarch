package com.siabul.cleanarch.domain

interface ShopListRepository {
    fun addShopItemToList(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int): ShopItem
    fun getShopList(): List<ShopItem>
    fun removeItemFromList(shopItem: ShopItem)
    fun updateShopItem(shopItem: ShopItem)

}