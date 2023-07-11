terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
    }
  }

  backend "s3" {
    bucket = "alloba-terraform-state-files"
    key = "alloba-mono"
    region = "us-east-1"
  }
}

provider "aws" {
  default_tags {
    tags = {
      project = "alloba-mono"
      managedBy = "Terraform"
      environment = terraform.workspace
    }
  }
}

module "central-dns" {
  source = "./central-dns"
  route_53_zone_name = "alexlbates.com"
}

module "personal-site" {
  source = "./cloudfront-s3-site"

  acm_certificate_domain = "alexlbates.com"
  cloudfront_distribution_description = "Main landing site for my online presence."
  route_53_record_names = ["alexlbates.com","www.alexlbates.com"]
  route_53_zone_name = "alexlbates.com"
  s3_bucket_name = "alexlbates.com"
}

module "kaleidoscope-site" {
  source = "./cloudfront-s3-site"
  acm_certificate_domain = "alexlbates.com"
  cloudfront_distribution_description = "Kaleidoscope Site"
  route_53_record_names = ["kaleidoscope.alexlbates.com"]
  route_53_zone_name = "alexlbates.com"
  s3_bucket_name = "kaleidoscope.alexlbates.com"
}