(ns gokhan-website.views.product-page
  (:use [hiccup core page])
  (:require
    [gokhan-website.presenters.product-page :as p]
    [gokhan-website.presenters.util :refer [add-hiccup]]
    [gokhan-website.views.page-utils :refer [page-template]]))

(defn format-product [product]
  (let [presented-product (p/present-product product)]
    [:div.product
     [:p.product-name (:product-name presented-product)]
     [:div.product-description (:product-description presented-product)]]))

(defn format-product-category [category]
  (let [product-presentations (map format-product (:products category))]
    [:div.product-category
     [:p.product-category (:product-category category)]
     (vec
       (concat [:div.product-category-scroll]
               (vec product-presentations)))]))

(defn format-product-categories [categories]
  (let [presented-categories (map format-product-category categories)]
    (vec presented-categories)))

(defn show [page-data]
  (let [categories (:categories page-data)]
    (page-template
      (add-hiccup [:div#products]
                  (format-product-categories categories))
      page-data)))

