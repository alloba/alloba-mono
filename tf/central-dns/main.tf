terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
    }
  }

  backend "s3" {
    bucket = "alloba-terraform-state-files"
    key = "central-dns"
    region = "us-east-1"
  }
}

provider "aws" {
  default_tags {
    tags = {
      project = "central-dns"
      managedBy = "Terraform"
      environment = terraform.workspace
    }
  }
}

variable "route_53_zone_name" {
  type = string
  description = "The base name to use for the hosted zone. Should be something like 'alexlbates.com'."
  default = "alexlbates.com"
}
