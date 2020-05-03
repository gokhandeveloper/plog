(ns gokhan-website.views.contact
  (:use [hiccup core page])
  (:require
    [gokhan-website.presenters.util :refer [add-hiccup markdown]]))

(defn show []
  [:div
   [:div.page-content
    (markdown (slurp "resources/files/contact.md"))
    ]]
  )
