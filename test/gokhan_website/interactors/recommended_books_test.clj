(ns gokhan-website.interactors.recommended-books-test
  (:require [clojure.test :refer [use-fixtures
                                  deftest
                                  testing
                                  is]]
            [gokhan-website.interactors.recommended-books :as books]
            [gokhan-website.interactors.test-util :refer [directory clear-directory]]
            ))

(defn create-book [file-name book-data]
  (spit (str directory "/" file-name) book-data)
  )

(deftest testGetBooks
  (testing "no books"
    (clear-directory)
    (let [books (books/get-books directory)]
      (is (= [] books))))

  (testing "one book"
    (clear-directory)
    (let [book {:title "Title"
                :author "Author"
                :publisher "Publisher"
                :date "Date"
                :description "Description"}]
      (create-book "b1" book)
      (is (= [book] (books/get-books directory)))))

  )
