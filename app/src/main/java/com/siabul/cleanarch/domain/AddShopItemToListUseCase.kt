package com.siabul.cleanarch.domain

class AddShopItemToListUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItemToList(shopItem: ShopItem) {
        shopListRepository.addShopItemToList(shopItem)
    }
}