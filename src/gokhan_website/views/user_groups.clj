(ns gokhan-website.views.user-groups
  (:use [hiccup core page])
  (:require
    [gokhan-website.presenters.util :refer [add-hiccup markdown]]))

(defn show []
  [:div
   [:div.page-content
    (markdown (slurp "resources/files/user-groups.md"))
    ]]
  )
