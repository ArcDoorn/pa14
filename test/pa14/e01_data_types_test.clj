(ns pa14.e01-data-types-test
  (:use clojure.test))

(def ??? :unknown)
;; Please fill in the ??? with correct answers in the lines tests below.
;; Changing other parts of the tests is cheeting. ;-)

(deftest use-data-structures
  (testing "accessing a vector"
    (let [vec [??? ??? ???]]
      
      (is (= (get vec 1) :a) "accessing the vector with get")

      (is (= (vec 2) "test object") "use the vector as a function")

      (is (= (concat (subvec vec 0 1) [??? ???])
             [1 2 3]) "a bit of simple manipulation"))))



