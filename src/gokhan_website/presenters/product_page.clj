(ns gokhan-website.presenters.product-page
  (:require
    [gokhan-website.presenters.util :refer [markdown]]))

(defn present-product [product]
  (update product :product-description markdown))


