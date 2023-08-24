package com.siabul.cleanarch.domain

class RemoveItemFromListUseCase(private val shopListRepository: ShopListRepository) {
    fun removeItemFromList(shopItem: ShopItem) {
        shopListRepository.removeItemFromList(shopItem)
    }
}