resource aws_acm_certificate "central" {
  domain_name = aws_route53_zone.primary.name
  validation_method = "DNS"
  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_acm_certificate_validation" "central_validation" {
  certificate_arn = aws_acm_certificate.central.arn
}

resource "aws_route53_zone" "primary" {
  name = "alexlbates.com"
}