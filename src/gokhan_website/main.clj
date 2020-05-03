(ns gokhan-website.main
  (:require [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]]
            [gokhan-website.routes :refer [app]]
            [environ.core :refer [env]]))


(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5001))]
    (run-server (app) {:port port})))
;
;
;(defn -main [& [port]]
;  (let [port (Integer. (or port (env :port) 5000))]
;    (jetty/run-jetty (site #'app) {:port port :join? false})))