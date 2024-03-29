# Postcard
### Setup Guide This application can be deployed on Azure with the following steps.  Prerequisites: - Terraform installed
- Azure CLI installed and authenticated with `az login`

#### Initialise the Project
The `tfstate` for the project is stored in Azure storage using the `azurerm` backend.
This script will make sure that this is configured and will allow Terraform to access it:
```bash
source init.sh
```
#### Create the Infrastructure
Terraform apply can be used to create the infrastructure:
```bash
terraform apply
```
#### Configure the Virtual Machines
You first need to configure the following envinronment variables:
```bash
export MYSQL_ROOT_PASSWORD="xxxx"
export MYSQL_USER="xxxx"
export MYSQL_PASSWORD="xxxx"
export MYSQL_DATABASE="xxxx"
```
The application stack can now be installed using Ansible:
```bash
./run-playbooks.sh
```
#### Access the Application
The application will now be accessible on https://default-website-postcard.uksouth.cloudapp.azure.com

This will be different if you have changed the `domain_name_suffix` in the `main.tf` file or are using a different Terraform workspace.

If you have reached the weekly limit for Let's Encrypt Certificate signings then you can change these to allow to create more.

#### Cleaning up
The infrastructure can be destroyed using:
```bash
terraform destroy
```
Be sure to also delete the storage account resource group used for the `tfstate`:
```bash
az group delete --name postcardtfstate
```

