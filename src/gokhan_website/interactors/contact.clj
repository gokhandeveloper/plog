(ns gokhan-website.interactors.contact
  (:require [ring.util.response :refer [redirect response]]
              [clojure.string :refer [trim blank? join]]
              [gokhan-website.views.contact :as view]
              [gokhan-website.interactors.sidebar :refer [get-sidebar-data]]
              [gokhan-website.views.page-utils :refer [page-template]]))

(defn exec []
  (let [page-data (get-sidebar-data)]
    (page-template (view/show) page-data)))