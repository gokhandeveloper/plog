(ns gokhan-website.interactors.user-groups
  (:require [ring.util.response :refer [redirect response]]
              [clojure.string :refer [trim blank? join]]
              [gokhan-website.views.user-groups :as view]
              [gokhan-website.interactors.sidebar :refer [get-sidebar-data]]
              [gokhan-website.views.page-utils :refer [page-template]]))

(defn exec []
  (let [page-data (get-sidebar-data)]
    (page-template (view/show) page-data)))