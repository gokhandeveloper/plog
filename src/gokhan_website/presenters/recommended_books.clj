(ns gokhan-website.presenters.recommended-books
  (:require
    [gokhan-website.presenters.util :refer [markdown]]))

(defn present-book [book]
  (update book :description markdown))


