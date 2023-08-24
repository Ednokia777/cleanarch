package com.siabul.cleanarch.data

import com.siabul.cleanarch.domain.ShopItem
import com.siabul.cleanarch.domain.ShopListRepository

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrimentId = 0
    override fun addShopItemToList(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrimentId++
        }
        shopList.add(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id: $shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun removeItemFromList(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun updateShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItemToList(shopItem)
    }
}