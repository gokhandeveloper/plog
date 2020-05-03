(ns gokhan-website.handler
  (:require [compojure.core :refer :all]
          [org.httpkit.server :refer [run-server]]
          [gokhan-website.routes :refer [app]]
          ))
(defn -main []
  (run-server (app) {:port 3001})
  )