(ns gokhan-website.views.about-me
  (:use [hiccup core page])
  (:require
    [gokhan-website.presenters.util :refer [add-hiccup markdown]]))

(defn show []
  [:div
   [:div.page-content
    (markdown (slurp "resources/files/about.md"))
    ]]
  )
