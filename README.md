# Spring Challenge
This is a practice project based on a assignment given by Digital House within the Meli Bootcamp.

In this project we're supposed to create a basic API structure for a social media based marketplacle, which will be called SocialMeli. The basic funcionalities are:
 - Create Seller and Customer entities, in a way that a Customer will be able of following a Seller, but no the other way around.
 - Create a Publication entity, on which will located a Product as well.
 - Create endpoints which will Allow actions such as follow, unfollow, get publications, get followers, etc.
 
 All the funcionalities and it's implementations can be found in the [Closed Issues section](https://github.com/onias-rocha/spring-challenge/issues?q=is%3Aissue+is%3Aclosed).

#### Table of Specifications associated with it's endpoints, Input and Output

|Funcionality |HTTP Method| Input 
|-----|--------|-----|
[US 0001] Follow Seller By Id|POST| [integer] customerId / [integer] sellerId
|[US 0002] Get Followers Count  |GET| [integer] sellerId
[US 0003] List Customers That Follows Seller|GET| [integer] sellerId  / [String] order (optional)
|[US 0004] List Sellers That User Follows  |GET| [integer] customerId / [String] order (optional)
[US 0005] Create New Publication|POST| JSON via Request Body
|[US 0006] Feed of Publications (Last Two Weeks)  |GET| [integer] customerId
[US 0007] Unfollow Seller|POST| JSON via Request Body
|[US 0008] List Customers That Follows (Ordered)  |GET| [integer] sellerId
[[US 0009] List Sellers That User Follows (Ordered)|GET| [integer] customerId
|[US 0010] Create New Promo Publication |POST| JSON via Request Body
[US 0011] Count Promo Publications |GET| [integer] sellerId
|[US 0012] Get Promo Publications by Seller Id|GET| [integer] sellerId






