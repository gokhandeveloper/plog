(defproject ubc-website "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :main gokhan-website.main
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [compojure "1.6.1"]
                 [ring "1.8.0"]
                 [hiccup "1.0.5"]
                 [markdown-to-hiccup "0.6.2"]
                 [markdown-clj "1.10.0"]
                 [me.raynes/fs "1.4.6"]
                 [clj-time "0.15.0"]
                 [http-kit "2.3.0"]
                 [org.clojure/data.json "0.2.6"]
                 [environ "1.1.0"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler gokhan-website.handler/-main}
  :profiles
  {:dev
   [{:plugins [[com.jakemccrary/lein-test-refresh "0.23.0"]]}
    {:dependencies [[javax.servlet/servlet-api "2.5"]
                    [ring/ring-mock "0.3.2"]]}]})
