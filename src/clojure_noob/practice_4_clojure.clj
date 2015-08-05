;============================
; 4clojure practice
;============================
; This is where I test my clojure knowedge with 4 clojure tests

;----------------------------
; map
;----------------------------

(map #(+ % 5) '(1 2 3))

;----------------------------
; filter
;----------------------------

(filter #(> % 5) '(3 4 5 6 7))

;------------------------------------
; last element (without using last)
;------------------------------------

;; This would work but I we can't use it
(last [1 2 3 4 5])

;; I like this. Its elegant
(first (reverse [1 2 3 4 5]))

;; Can shorten it with compose
;;  This also lets it work in the boolean answer form
((comp str +) 8 8 8)
((comp first reverse) [1 2 3 4 5])

;; Other ways involve counting and using nth
(nth (count [1 2 3 4 5]))

;; Count the values, then decrement because we have base 0,
;;  then get that value by index
(nth [1 2 3 4 5] (dec (count [1 2 3 4 5])))

;; Could put this in an anonymous function
(#(* % 3) 8)

;; the array is passed in as %
;; we use it twice as a value and to find the last index
(#(nth % (dec (count %))) [1 2 3 4 5])

;----------------------------
; Penultimate Element
;----------------------------

;; we can just use the second command
((comp second reverse) (list 1 2 3 4 5))

;; But if we want it to be any value by index from last we should use nth
(#(nth (reverse %) 1) (list 1 2 3 4 5))

