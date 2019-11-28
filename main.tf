terraform {
  backend "azurerm" {
    storage_account_name  = var.storage_account_name
    container_name        = "tfstate"
    key                   = "terraform.tfstate"
  }
}

provider "azurerm" {
	version = "~> 1.37.0"
}

module "website" {
  source = "./modules/website"
  admin_user = "jenkins"
  resource_group = azurerm_resource_group.default
  virtual_network = azurerm_virtual_network.default
  subnet_cidr = "10.0.1.0/24"
  domain_name_suffix = "postcard"
}

module "api" {
  source = "./modules/api"
  admin_user = "jenkins"
  resource_group = azurerm_resource_group.default
  virtual_network = azurerm_virtual_network.default
  subnet_cidr = "10.0.2.0/24"
  domain_name_suffix = "postcard"
}

module "database" {
  source = "./modules/database"
  admin_user = "jenkins"
  resource_group = azurerm_resource_group.default
  virtual_network = azurerm_virtual_network.default
  subnet_cidr = "10.0.3.0/24"
  domain_name_suffix = "bob-crutchley"
}

resource "azurerm_resource_group" "default" {
  name     = terraform.workspace
  location = "uksouth"
}

resource "azurerm_virtual_network" "default" {
  name                = "${terraform.workspace}-vnet"
  address_space       = ["10.0.0.0/16"]
  location            = azurerm_resource_group.default.location
  resource_group_name = azurerm_resource_group.default.name
}

