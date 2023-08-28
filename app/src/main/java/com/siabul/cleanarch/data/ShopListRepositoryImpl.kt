package com.siabul.cleanarch.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.siabul.cleanarch.domain.ShopItem
import com.siabul.cleanarch.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private val shopListLiveData = MutableLiveData<List<ShopItem>>()
    private var autoIncrimentId = 0

    init {
        for(i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItemToList(item)
        }
    }
    override fun addShopItemToList(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrimentId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id: $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLiveData
    }

    override fun removeItemFromList(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun updateShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItemToList(shopItem)
    }

    private fun updateList() {
        shopListLiveData.value = shopList.toList()
    }
}