(ns gokhan-website.views.page-utils
  (:use [hiccup core page])
  (:require
    [gokhan-website.presenters.events :as events]
    [gokhan-website.presenters.articles :as articles]
    [gokhan-website.presenters.util :refer [add-hiccup]]))

(defn format-event [event]
  (let [presentation (events/present-event event)]
    [:div.event
     [:p.event (:date presentation)]
     [:div.event-description (:description presentation)]]))

(defn format-events [events]
  (vec (map format-event events)))

(defn format-article [{:keys [link title date]}]
  [:div.article
   [:a.article-title {:href link} title]
   [:p.article-date date]])

(defn format-articles [articles]
  (map format-article (articles/present-articles articles)))

;link from publish.twitter.com
(def embedded-twitter-feed "<a class=\"twitter-timeline\" data-width=\"400\" data-height=\"400\" data-theme=\"light\" href=\"https://twitter.com/gokhanhere?ref_src=twsrc%5Etfw\">Tweets by Gokhan</a> <script async src=\"https://platform.twitter.com/widgets.js\" charset=\"utf-8\"></script>")

(defn page-template [content {:keys [message events articles]}]
  (html5
    [:head
     [:title "Gokhan's Blog - Programming, software architecture, technology"]
     (include-css "/css/nav.css")
     (include-css "/css/style.css")
     ]
    [:body
     [:div#header
      [:a {:href "/"}[:p#ubc "Gokhan Dilek"]]
      [:p#ubc-subtitle ""]]
     [:div.nav-toggle
      [:div#menu "MENU"]
      [:div.nav-toggle-bar ]
      ]
     [:nav.nav
      [:ul
       [:li
      [:a.tab {:href "/about"} "About"]]
       [:li
      [:a.tab {:href "books"} "Recommended Books"]]
        [:li
      [:a.tab {:href "blogs"} "Blogs"]]
         [:li
      [:a.tab {:href "#"} "Archived Blogs"]]
          [:li
      [:a.tab {:href "register"} "Subscribe"]]
           [:li
      [:a.tab {:href "/contact"} "Contact"]]
      ]]
     (when-not (nil? message) [:div#message message])
     [:div#content-area
     content]
     [:div#sidebar
      (add-hiccup [:p.sidebar-title "Upcoming Projects"]
                  (format-events events))
      (add-hiccup [:p.sidebar-title "Latest Tweets"]
                  embedded-twitter-feed)
      (add-hiccup [:p.sidebar-title "Recent news from the interwebs"]
                  (format-articles articles))

      ]
     (include-js "/js/nav.js")
     ]))