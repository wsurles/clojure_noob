;=======================================================
;=======================================================
; Do Things
;=======================================================
;=======================================================
; This is the awesome CLoure 4 the brave and true tutorial
; http://www.braveclojure.com/

(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello world!"))

;=======================================================
;=======================================================
; Do Things
;=======================================================
;=======================================================

;================
; 1 Syntax
;================

;--------------
; 1.1 Forms
;--------------

; Literat Representations
; 1
; "string"
["a" "vector" "of" "strings"]

; Forms will always consist of an operator
; and operands
; (operator operand1 operand2 ... operandn)

(+ 2 2)

(* 1 2 3 4 5)

(+ 1 2 3)

(str "it was the panda " "in the library " "with a dust buster")

;------------------
; 1.2 Control Flow
;------------------

; IF
(if true
  "abra cadabra"
  "hocus pocus")

; notice that each branch of the if can have only one form
; to get around this you can use the do operator

(if false
  (do (println "success!")
    "abra cadabra")
  (do (println "Failure :(")
    "hocus pocus"))

; success or failure is printed and a value is returned

; WHEN
(when true
  (println "Success!")
  "abra cadabra")

; use 'when' when you want to do multiple things if something is true
; and nothing if it is false

; thats really it for important control flow

;---------------------------------
; 1.3 Naming things with def
;---------------------------------

; use def to bind a name to a value

(def failed-protagonist-names
  ["Larry Potter"
   "Doreen the Explorer"
   "The Incredible Bulk"])

(println failed-protagonist-names)

(def severity :high)
(def error-message "OH GOD! IT'S A DISASTER! WE'RE ")
(if (= severity :mild)
  (def error-message (str error-message "MILDLY INCONVENIENCED."))
  (def error-message (str error-message "DOOOOOOOOMED!")))

(println error-message)

; note: this is really bad clouse

;===================
; 2 Data Structures
;===================

; All of clojures data structures are immutable
; You cannot add change the first value in a
; defined vector for example

; There is a reason for this but lets just learn how
; to do things without all that philosphizing for now

;---------------------------------------------------
; 2.1 Nil, True, False, Truthiness, Equality
;---------------------------------------------------

; nil means 'no value'
(nil? 1)

(nil? nil)

;nil and false represent logical falsiness
(= 1 1)

(= nil nil)

(= 1 2)

; you use = for all data structures. Nothing special for stings or anything

;-------------------
; 2.2 Numbers
;-------------------

; for more info on numbers check out:
; http://clojure.org/data_structures#Data Structures-Numbers
; and for topics like coercion and contagion

; 93 integer
; 1.2 float
; 1/5 ratio

;-------------------
; 2.3 Strings
;-------------------

"Lord Voldemort"
"\"He who must not be names\""
"\"Great cow of Moscow!\" - Hermes Conrad"

(println "\"He who must not be names\"")

; can only use double quotes to delineate strings

; can only concatenate using the str function

(def a_name "Chewbacca")
(str "\"Uggllgllglglglll\" - " a_name)

;-------------------
; 2.4 Maps
;-------------------

; maps are similar to dictionaries or hashes in other languages

; An empty map
{}

; ":a", ":b", ":c" are keywords
{:a 1
 :b "boring example"
 :c []}

; Associate "string-key with the "plus" function
{"string-key" +}

; Maps can be nested
{:name {:first "John" :middle "Jacob" :last "Jingleheimerschmidt"}}

; map values can be any type, even functions

; you can lookup values with the get function
(get {:a 0 :b 1} :b)

(get {:a 0 :b {:c "ho hum"}} :b)

; get will return nil if it cant find your value
; you can give it a default value to return
(def my_map {:a 0 :b 1})
(get my_map :c)
(get my_map :c "Unicorns")

; get-in lets you look values in nested maps
(def my_map {:a 0 :b {:c "ho hum"}})
(get-in my_map [:b :c])

; another way to look up a value in a map is to treat the map
; like a function, with the key as its arguments
({:name "The Human Coffee Pot"} :name)

; 'Real' CLojurist hardly ever do this though

;-------------------
; 2.5 Keywords
;-------------------

; anything that comes after : it seems is a keyword
; they are mainly used to lookup values in maps

; keywords can be used as function which looks up the corresponding value
; in a data structure
(def my_map {:a 1 :b 2 :c 3})
(:a my_map)

; this is similar to
(get my_map :a)

(:d my_map "Faeries")

; Besides using map literals you can use the hash-map function
; to create a map
(hash-map :a 1 :b 2)

; you can make sorted maps

;-------------------
; 2.6 Vectors
;-------------------

; a vector literal
[3 2 1]

; Here we're returning an element of a vector
(get [3 2 1] 0)

; Another example of getting by index. Notice as well that vector
; elements can be of any tupe and you can mix types.
(get ["a" {:name "Pugsley Winterbottom"} "c"] 1)

; This is the same get function as used to get values from a map

; Elements get added to the end of a vector
; conjoin
(conj [1 2 3] 4)


;-------------------
; 2.7 Lists
;-------------------

; List are similar to vectors
; You can't retrieve list elements with get

; Here is a list - note the preceding single quote
'(1 2 3 4)

; Does not work for lists
(get '(100 200 300 400) 0)

; This works but has different performance characteristics
; which we don't care about right now.
(nth '(100 200 300 400) 3)

; you create lists with the list function
(list 1 2 3 4)

; Elements get added to the begining of a list:
(conj '(1 2 3) 4)

; For now you are best off just using vectors

;-------------------
; 2.8 Sets
;-------------------

; Sets are collections of unique values
#{"hannah montanna" "miley cyrus" 20 45}

; If you try to add :b to a set which already contains :b,
; the set still only has one :b
(conj #{:a :b} :b)

; You can check whether a value exists in a set
(get #{:a :b} :a)
(:a #{:a :b})

(get #{:a :b} "hannah montanna")

; you can create sets from existing vectors and lists
; use the set function to do this
(set [3 3 3 4 4])

; you can check whether an element exisits in a collection
; 3 exists in a vector
(get (set [3 3 3 4 4]) 3)

; but 5 does not
; the nil is similar to a false here
(get (set [3 3 3 4 4]) 5)

; just as you can create hash maps and sorted maps
; you can create hash sets and sorted sets
(hash-set 1 1 3 1 2)
(sorted-set :b :a :c)

(set #{:a :b :c})
(sorted-set #{:c :b :a})

(set #{3 2 1})
(sorted-set #{3 2 1})

; Im not quite sure how it decides how to sort
; but lets move on for now. Almost done with part 2

;----------------------------------
; 2.9 Symbols and Namings
;----------------------------------

; Symbols are identifiers that are normally used to refer to something
(def failed-movie-titles
  ["Gone with the moving air"
   "Swellfellas"])

; Lisp allows you to manipulate symbols as data
; We will see this alot when we work with macros
; Functions can return symbols and take them as arguments

; Identity returns its argument
(identity 'test)

; Its okay to bot be impressed for now. (good because I am not)

;-------------------
; 2.10 Quoting
;-------------------

; using the single quote is called "quoting"

; giving clojure a symbol returns the object it refers to
failed-protagonist-names

(first failed-protagonist-names)

; Quoting a symbol tells clojure to use the symbol itself as a
; data structure not the object it refers to.
'failed-protagonist-names

; Ahhh, interesting

(eval 'failed-protagonist-names)

; This would fail
;(first 'failed-protagonist-names)
; throws exception!

(first ['failed-protagonist-names
        'failed-antagonist-names])

; You can also quote collections like lists, maps, and vectors.
; All symbols within the collection will be unevaluated.
'(failed-protagonist-names 0 1)

(first '(failed-protagonist-names 0 1))

(second '(failed-protagonist-names 0 1 ))

;-------------------
; 2.11 Simplicity
;-------------------

; clojures emphasis on simplicity encourages you to reach
; for the built-in "basic" data structure first
; before creating new types and classes.

; sweet. done with the data structures
; time for dig into functions and see how these data structures can be used.

;===================
; 3 Functions
;===================

;-------------------------
; 3.1 Calling Functions
;-------------------------

; These are all examples of function calls
(+ 1 2 3 4)
(* 1 2 3 4)
(first [1 2 3 4])

; You can return functions from functions
; A 'funciton expression' is an expression that returns a function.
; Here is a weird example of a function that returns the '+' operator

; Return value of "or" is first truthy valye, and + is truthy
; + is the last truthy value
(or + - )

; you can use this as the operator in another expression
; Return value of "and" is first falsey value or last truthy value.
((or + -) 1 2 3)
((and + -) 1 2 3)

; A couple more ways to return 6

; (wow, this is a wierd example. Not sure how this is useful except to be weird)
((and (= 1 1) +) 1 2 3)

; Return value of "first" is the first element in a sequence
((first [+ 0]) 1 2 3)

; These are not valid function calls
; Numbes are not functions
; (1 2 3 4)
; ("test" 1 2 3)

; you will likely see this error many times as you learn clojure
; "x cannot be cast to clojure.lang.IFn"
; just means you are trying something as a function when its not

; Functions can also take any expression as arguments - including other functions

; map (the function, not the data structure) creates a new list by
; applying a function to each member of a collection.
; The "inc" function increments a number by 1
(inc 1.1)
(map inc [0 1 2 3 ])
; That is awesome!
; Note that map does not return a vector. More about that later

; Map allows you to generalize the process of transforming a collection by
; applying a function - any function - over any collection

; Clojure evaluates all function arguments recursively before passing them to the function.
; Heres how clojure would evaluate a function call whose arguments are also function calls.
(+ (inc 1999) (/ 100 (- 7 2)))
; All sub-forms are evaluated before applying the "+" function
(+ 200 (/ 100 (- 7 2)))
(+ 200 (/ 100 5))
(+ 200 20)
; 220

;------------------------------------------------------
; 3.2 Function Calls, Marco Calls, and Special Forms
;------------------------------------------------------

; Funtion calls are expressions which have a function expression as the operator
; There are two other kinds of expressions. Macro calls and special forms.
; Special forms are like 'def' and 'if'
; We'll cover marcos and special forms more later
; The main thing that makes special forms special is that they do not always
;   evaluate all of there operands

; (if boolean-form
;    then-form
;    optional-else-form)

; Another feature which differentiates special forms is that you
; can't use them as arguments to functions.

; There are only a handful of clojure special forms.

; Macros are similar to special forms in that they evaluate there operands differently
;  from function calls. They also cannot be passed as arguments to functions

;-------------------------
; 3.3 Defining Functions
;-------------------------

; Function definitions are comprised of 5 main parts
; - defn
; - a name
; - (optional) a docstring
; - parameters
; - the function body

;; (defn a-name
;;  "optional docstring"
;;   [parameters]
;;   the function body)

; here is an example of a function definition and calling the function
(defn too-enthusiastic
  "Return a cheer that mignt be a bit too entusiastic"
  [name]
  (str "oh. my. god! " name " You are most definitely like the best "
       "man slash woman ever I love you and we shold run away to somewhere"))

(too-enthusiastic "Zelda")

; --- 3.3.1 The Docstring -------------------------

; You can view the docstring for a function in the REPL with (doc fn-name)
; e.g. (doc map).
; The docstring is also utilized if you use a tool to generate documentation for your code.
; In the above example, "Return a cheer that might be a bit too enthusiastic" is the docstring.

; --- 3.3.2 Parameters -----------------------

; Clojure functions can be defined with zero or more parameters
(defn no-params
  []
  "I take no parameters!")

(defn one-param
  [x]
  (str "I take one param: " x " It'd better be a string!"))

(defn two-params
  [x y]
  (str "Two parameters! That's nothing! Pah! I will smoosh them "
       "together to spite you! " x y))

; Functions can also be overloaded by arity. This means that a different function body will run
;   depending on the number of arguments passed to the function.
; Here is the general form of a multiple-arity function definition. Notice that each arity definition is
;   enclosed in parentheses and has an argument list.
(defn multi-arity
  ; 3-arity arguments and body
  ([arg1 arg2 arg3]
   (+ arg1 arg2 arg3))
  ; 2-arity arguments and body
  ([arg1 arg2]
   (- arg1 arg2))
  ; 1-arity arguments and body
  ([arg1]
   (str "this is the only arg: " arg1)))

(multi-arity 3 2 1)
; This is just like looking up the number of args and doing an if statement with different operations

; This is one way to provide default values for arguments.
; For example, here, karate is the default argument for the chop-type param
(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

; This seems like a weird wy to do this. In R you just set defaults param3=TRUE in the function definition
;   and if a user does not put in that parameter than the default will be used.

; If you call x-chop with two arguments, then the function works just as it would if it
;  weren't a multi-arity function.
(x-chop "Kanye West" "slap")

; If you call x-chop with only one argument, though, then x-chop will actually
;   call itself with the second argument "karate" supplied.
(x-chop "Kanye West")

; whoa, that is some scary recursion
; if these seems unusual then it means you are learning new things and that is good.

; You can also make arity do something completely unrelated.
(defn weird-arity
  ([]
   "Destiny dressed you this morning my friend, and now Fear is
   trying to pull off your pants. If you give up, if you give in,
   your're gonna end up naked with Fear just standing there laughing
   at your dangling unmentionables! - the Tick")
  ([number]
   (inc number)))

(weird-arity 5)
(weird-arity)

; But most likely you don't want to do this.

; Clojure allows you to define variable-arity functions by
;   including a "rest-param", as in "put the rest of these
;   arguments in a list with the following name"
(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers] ;; the ampersand indicates the "rest-param"
  (map codger-communication whippersnappers))

(codger "Billy" "Anne-Marie" "The Incredible Bulk")
; As you can see, when you provide arguments to variable-arity functions
;   the arguments get treated as a list.

; map is a cool way to apply funcitons to arrays without looping. Like mutate in dplyr.

; You can mix rest-params with normal params, but the rest-param has to come last:
(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(favorite-things "Doreen" "gum" "shoes" "kara-te")

; Finally, Clojure has a more sophisticated way of defining parameters
;   called "destructuring", which deserves its own subsection.

; --- 3.3.3 Destructuring ------------------------

; The basic idea behind destructuring is that it lets you concisely
;   bind symbols to values within a collection. Lets' look at the basic example.

; Return the first element of a collection
(defn my-first
  [[first-thing]] ; Notice that first-thing is whithin a vector
  first-thing)

(my-first ["oven" "bike" "waraxe"])

; Here is how you would accomplish the same thing without destructuring
(defn my-other-first
  [collection]
  (first collection))

(my-other-first ["nickel" "hair"])

; As you can see, the 'my-first' associates the symbol first-thing with the first
;   element of the vector that was passed in as an argument. You tell my-first
;   to do this by placing the symbol first-thing within a vector

; This is how I am used to function calls in R. Where you can pass in any variable and it will get
;   the name that is in the same location in the function. But here in clojure it works inside of a vector.
;   You can pass a vector of values and rename them by location.

; That vector is like a huge sign held up to Clojure which says. "Hey! This function is going to
;   recieve a list or a vector or a set as an argument. Make my life easier by taking apart the
;   arguments's structure for me and associating meaningful names with different parts of the
;   argument!"

; When destructuring a vector or list, you can name as many elements
;   as you want and also use rest params
(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))

(chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"])

; Oh, now that makes a lot more sense
; Rest params are key if you want to destructure.

; You can also destructure maps. In the same way that you tell Clojure
;   to destructure a vector or list by providing a vector as a parameter,
;   you destructure maps by providing a map as a parameter

(defn announce-treasure-location
  [{the_lat :lat the_lng :lng}]
  (println (str "Treasure lat: " the_lat))
  (println (str "Treasure lng: " the_lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})

; Lets look more at this line:
; [{the_lat :lat the_lng :lng}]

; This is like telling Clojure. "Yo! Clojure! Do me a fava and associate the symbol the_lat with the
;   value corresponding to the key :lat. Do the same thing with the_lng and :lng, ok?."

; We often want to just take keywords and "break them out" of a map, so there's a shorter syntax for that

; Works the same as above.
(defn announce-treasure-location
  [{:keys [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})

; I like that.

; You can retain access to the original map argument by using the :as keyword. In the example
;   below, the original map is accessed with treasure-location:

; Works the same as above
(defn steer-ship!
  [{:keys [lat lng] :as treasure-location}]
  (println (str "Steer ship to Treasure - lat: " lat))
  (println (str "Stear ship to Treasure - lng: " lng)))

; One would assume that this would put in new coordinates for your ship
(steer-ship! {:lat 28.22 :lng 81.33})

; I had to change that last part around a little bit so that it worked.
; The treasure-location needs to be defined ahead of time I think
; Mostly just changing the function name to steer-ship!

; In general, you can think of destructuring as instructing Clojure how to associate symbols with
;   values in a list, map, set, or vector.

; Now, on to the part of the function that actually does something: the function body!

; --- 3.3.4 Function Body --------------------------

; Your function body can contain any forms. Cojure automatically returns the last form evaluated.

(defn illustrative-function
  []
  (+ 1 304)
  30
  "joe")
(illustrative-function)

(defn number-comment
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number's OK, I guess"))

(number-comment 5)
(number-comment 7)


; --- 3.3.5 All Functions are Created Equal ---

; In clojure, there are no privleded functions. + and - are just functions.
;   It treats all functions the same. You don't need to worry about special
;   rules or syntax for working with functions. Thay all work the same.


;----------------------------
; 3.4 Anonymous Functions
;----------------------------

; Your function don't need names
; Actually, you will use Anonymous functions all the time.

; There are two ways to create anonymous functions.
; Here is the first way.
;(fn [param-list] function body)

; Here is an example. Inline mapping a function to a vector
(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Mr. Magoo"])

((fn [x] (* x 3)) 8)

; In this way, you can treat fn nearly identically to defn.

; You could associate your anonymous function with a name
(def my-special-multiplier (fn [x] (* x 3)))
(my-special-multiplier 12)

; There is another more compact way to create anonymous functions
; Whoa this looks weird
;#(* % 3)

; Apply this weird looking thing
(#(* % 3) 8)

; Another example
(map #(str "Hi, " %)
     ["Darth Vader" "Mr. Magoo"])

; Me exploring
(map #(* % 3)
     [1 2 3 4 5])
; Yes finally. This is how you map an anonymous multipcation function to an array

; It looks a lot like a function call but just with a # in front
(* 8 3)
(#(* % 3) 8)
; Its supposed to be easy to read what will happen when the function
;   is applied

; If your anon function takes multiple arguments you can distinguish
;   them like this %1 %2 %3 etc
(#(str %1 " and " %2) "corn bread" "butter beans")

; You can also pass a rest param
(#(identity %&) 1 "blarg" :yip)

; The main difference between this form and fn is that the form can easily
;   become unreadable and is best used for short functions

;--------------------------
; 3.5 Returning Functions
;--------------------------

; Functions can return other functions. THe returned functions are closures, which means
;   that they can access all the variables that were in scope when the function was created.
; I do not know what this means

;; inc-by is in scope, so the returned function has access to it even
;; when the returned function is used outside inc-maker
(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)

; woohoo!

;===========================
; 4 Pulling it all together
;===========================

; Lets pull this all together and use our knowledge for a noble purpose: smacking around hobits!

; To hit a hobbit, we'll first model its body parts. Each body part will include its relative
;   size to help us deterimine how likekly it is that that part will be hit.

; In order to avoid repetition, this hobbit model will only include entries for "keft foot, "left ear",
;   etc. We'll need a function to fully symmetrize the model.

; Finally, we'll create a function which iterate over our body parts and randomly chooses the one hit.

; Fun!? This is a wierd example. I hope he explains how this is relevant

;---------------------------------
; 4.1 The Shire's Next Top Model
;---------------------------------

; For our hobbit model, we'll eschew such characteristics as "joviality" and "mischievousness" and
;   focus only on the hobbit's tiny body. Here's our hobbit model:

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

; This is a vector of maps. Each map has the name of a body part and relative zie of the body part
; The hobbits right size is missing. Lets fix that. This is complex code. It introduces some ideas
;   we haven't covered yet. Don't worry becasue we are going to examine it in great detail.

(defn needs-matching-part?
  [part]
  (re-find #"^left-" (:name part)))

(needs-matching-part? {:name "left-eye"})
(needs-matching-part? {:name "neckbeard"})

(if (needs-matching-part? {:name "left-eye"})
  (println "true")
  (println "false"))

(defn make-matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "expects a seq of maps which have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts
            final-body-parts (conj final-body-parts part)]
        (if (needs-matching-part? part)
          (recur remaining (conj final-body-parts (make-matching-part part)))
          (recur remaining final-body-parts))))))

(symmetrize-body-parts asym-hobbit-body-parts)

; Lets break this down!

;-------------------
; 4.2 let
;-------------------

; In our symmetrizer above, we saw the following:
; (let [[part & remaining] remaining-asym-parts
;            final-body-parts (conj final-body-parts part)]
;        (if (needs-matching-part? part)

; All this does is bind the names on the left to the values on the right. You can think of let as
;   short for "let it be". For example, "Let final-body-parts be (conj final-body-parts part)."

; Here are some simpler examples:
(let [x 3]
  x)

(def dalmatian-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])

(let [dalmatians (take 3 dalmatian-list)]
  dalmatians)

; Let also introduces a new scope:
(def x 0)
(let [x 1] x)

; However, you can reference existing bindings in your let binding:
(def x 0)
(let [x (inc x)] x)

; You can also use rest-params in let, just like you can in functions:

(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians])

;; Okay, This says make a vector. pongo is the first element, dalmations are all the rest.
;; Make it from the dalmations list. so [pongo dalmations] are now split. Makes sense.

; Notice that the value of a let form is the last form in its body which gets evaluated.

; Let forms follow all the destructuring rules which we introduced in "Calling a Function" above.

; One way to think about let forms is that they provide parameters and their arguments side-by-side.
;   Let forms have two main uses:
;   1. They provide clarity by allowing you to name things
;   2. They allow you to evaluate an expression only once and re-use the result. This is especially
;       important when you need to re-use results of an expensive function call, like a network API call.
;       Its also important when the expression has side effects.

;; So a let form lets me do an operation inside another form to clean up the names of things.
;; This can make the code much much more readable. Its kind of like defining a new variable
;; and then using that variable. But it happens inside the form where the variable is being used.

;; Here is a good description of the difference between let and def from stack over flow...
;; You can only use the lexical bindings made with let within the scope of let (the opening
;;   and closing parens). Let just creates a set of lexical bindings. I use def for making
;;   a global binding and lets for binding something I want only in the scope of the let as
;;   it keeps things clean. They both have their uses.

;;   (let [s (foo whatever)]
;;     ;; s is bound here
;;     )
;;   ;; but not here
;;   (def s (foo whatever))
;;   ;; s is bound here


; Look again at the symmetrizing function.
;; Associate "part" with the first element of "remaining-asym-parts"
;; Associate "remaining" with the rest of the elements in "remaining-asym-parts"
;; Associate "final-body-parts" with the result of (conj final-body-parts part)

;; (let [[part & remaining] remaining-asym-parts
;;            final-body-parts (conj final-body-parts part)]
;;        (if (needs-matching-part? part)
;;          (recur remaining (conj final-body-parts (make-matching-part part)))
;;          (recur remaining final-body-parts)))

; Notice that part, remaining, and final-body-parts each gets used multiple times in the
;   body of the let. If, instead of using the names part, remaing, and final-body-parts
;   we used the original expression, it would be a mess!. For example

;;  (if (needs-matching-part? (first remaining-asym-parts))
;;  (recur (rest remaining-asym-parts)
;;         (conj (conj final-body-parts (first remaining-asym-parts))
;;               (make-matching-part (first remaining-asym-parts))))
;;  (recur (rest remaining-asm-parts)
;;         (conj (conj final-body-parts (first remaining-asym-parts)))))

; So, let is just a handy way to introduce names for values.

;-------------------
; 4.3 loop
;-------------------

;; Loop provides another wy to do recursion in Clojure.
;; Lets look at a simple example

(loop [iteration 0]
  (println (str "iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye")
    (recur (inc iteration))))

;; You could acomplish the same thing just using functions
(defn recursive-printer
  ([]
   (recursive-printer 0))
  ([iteration]
   (println iteration)
   (if (> iteration 3)
     (println "Goodbye!")
     (recursive-printer (inc iteration)))))
(recursive-printer)

;; easy recursion loop
;; It seams to be common to do a loop with an if else and a recursion in clojure
(loop [sum 0 cnt 10]
  (if (= cnt 0)
    sum
    (recur (+ cnt sum) (dec cnt))))

;------------------------------
; 4.4 Regular Expressions
;------------------------------

;; In our symmetrizer, re-find returns true or false base on whether ther part's name
;;   starts with the string "left-".

(defn needs-matching-part?
  [part]
  (re-find #"^left-" (:name part)))
(needs-matching-part? {:name "left-eye"})
(needs-matching-part? {:name "neckbeard"})

;; make-matchin-part uses a regex to replace "left-" with "right-"
(defn make-matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})
(make-matching-part {:name "left-eye" :size 1})



;-------------------
; 4.5 Symmetrizer
;-------------------

;; The symmetrizer explained in my own words, step by step.

(defn symmetrize-body-parts  ; define the function name
  "Expects a seq of maps which have a :name and :size" ; describe the function
  [asym-body-parts] ; what gets passed in
  (loop [remaining-asym-parts asym-body-parts ; start a loop with initial conditions. assign all parts to remaining-asm-parts
         final-body-parts []] ; asign an empty array to final-body-parts
    (if (empty? remaing-asym-parts) ; check to see if we have no parts left to copy
      final-body-parts ; if so, return the final list of body parts
      (let [[part & remaining] remaining-asym-parts ; otherwise, we do more. make a couple simple variables.
                                                    ; split remaing parts into part and remining which we wil use
            final-body-parts (conj final-body-parts part)] ;add part to final body-parts
            (if (needs-matching-part?) ; then use those to add a new part if needed
              (recur remiaing (conj final-body-parts (make-matching-part))) ; return to the begining of the loop
                                                                            ; remaing and the final body parts list with a new part
              (recur remaining final-body-parts)))))) ; if matching part is not needed return reamining and the final parts list

;; It would be good for me to write this in R and then return and write it in clojure
;; It would also be good to practice copying some dply summarizations and actions into clojure

;-------------------------------------
; 4.6 Shorter Symmetrizer with Reduce
;-------------------------------------

;; The pattern of "process each element in a sequene and build a result" is so common that theres's
;;   a function for it: reduce.

;;Sum with reduce
(reduce + [1 2 3 4])

;; thats the same as this
(+ (+ (+ 1 2) 3) 4)

;; I'm going to need a better example of why this is useful.
;; I could also just do this...
(+ 1 2 3 4)

;; Reduce works like this:
;; 1. Apply the given function to the first two elements of a seqence
;; 2. Apply the given function to the result and  the next element of a sequence.
;;    In this case the result of step 1 is 3, and the next element of the sequence is 3 as well.
;;    So you end up with (+ 3 3) or 6.
;; 3. Repeat setp 2 for every remaining element in the sequence.

;; Reduce also takes an optional initial value. 15 is the initial value here.
(reduce + 15 [1 2 3 4])

;; If you provide an initial value than reduce starts by applying the given function to the initial value
;;   and the first element o the sequence, rather than the irst two elements othe sequence.

;; Here is one way reduce could be implemented:
(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))

(my-reduce + 15 [1 2 3 4])

;; We could reimplement symmetrize as follows:
(defn better-symmetrize-body-parts
  "Expects a seq of maps which have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part] ; this is the function. inital empty list is now 'final-body-parts' and first part in map is 'part'
            (let [final-body-parts (conj final-body-parts part)] ; first add the part to the final list
              (if (needs-matching-part? part) ; then if it needs a match
                (conj final-body-parts (make-matching-part part)) ; make a match add that to the final list
                final-body-parts))) ; if no match is need that just return the part list
          []  ; initial value is an empty list
          asym-body-parts)) ;the pass in the map of parts

;; Test it
(def asym-hobbit-body-parts-short [{:name "left-eye" :size 1}
                                   {:name "head" :size 3}
                                   {:name "left-ear" :size 1}])

(better-symmetrize-body-parts asym-hobbit-body-parts-short)


;---------------------
; 4.7 Hobbit Violence
;---------------------

;; Now, lets create a funtion that will determine which part of the hobbit gets hit:
(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts) ; symmetrize the parts
        body-part-size-sum (reduce + 0 (map :size sym-parts)) ; sum the size of all parts
        target (inc (rand body-part-size-sum))] ; choose a target with a random number. inc so its greater than 0
    (loop [[part & rest] sym-parts ;part is first and the rest are rest
           accumulated-size (:size part)] ;accumulated-size is the size of all the part seen so far
      (if (> accumulated-size target) ; if size is greater than target
        part ; hit that part
        (recur rest (+ accumulated-size (:size part))))))); otherwise recur and add part sizes

(hit asym-hobbit-body-parts)

;; This is actually not so clear. Its clever but not that clear. Most of this is just about deciding
;;   which part to hit. Its based on a random number and designed to be weighted by part size.
;;   So larger parts have a higher chance of being hit.
;;   I guess it does teach a lot of the basic clojure functions.
;;   I could make it simpler to follow without recursion and loops and ifs.

;; This is me trying to simplifiy this.

;; Symmetrize the parts with the function
(def sym-parts (better-symmetrize-body-parts asym-hobbit-body-parts))
sym-parts

;; get the sum of all part sizes
(def body-part-size-sum (reduce + 0 (map :size sym-parts)))
body-part-size-sum

;; get cumsum vector of part sizes
(def body-part-size-cumsum (reductions + 0 (map :size sym-parts)))
body-part-size-cumsum

;; pick a random number between 0 and sum of part sizes
(def target (inc (rand body-part-size-sum)))
target

;; choose the cumsum value the represents the target part
(def part_sum_val (last (filter #(< % target) body-part-size-cumsum)))
part_sum_val

;; get the part index
(def part_num (.indexOf body-part-size-cumsum part_sum_val))
part_num

;; get the part
(nth sym-parts part_num)

;; Yay, I got it and with out weird ifs and loops and recursion. Sheesh
;; Here is a simpler function that will set all these values and return the part
;; All it takes is a cummulative sum vector and a look up.
;; I'm just learning this so I split it all up. There may be an easier way to get the value
;; I do it with a filter and index and nth statements
;; This is also executable line by line here so you can see whats happening with the variables

(defn hit-part
  [sym-parts]
  (let [body-part-size-sum (reduce + 0 (map :size sym-parts))
        body-part-size-cumsum (reductions + 0 (map :size sym-parts))
        target (inc (rand body-part-size-sum))
        part_sum_val (last (filter #(< % target) body-part-size-cumsum))
        part_ind (.indexOf body-part-size-cumsum part_sum_val)
        part (nth sym-parts part_ind)]
    part))

var <- if (xx) {
    a
} else {
    b
}

(hit-part sym-parts)

;; Examples that helped me build this:

;; How to do a cummulative sum with reductions
(def s [1 2 3 4 5 6 7 8 9 10])
(reductions + s)

;; filter example
(first (filter #(= % 1) '(3 4 1)))

;; get index example
(def v ["one" "two" "three" "two"])

(.indexOf v "two")

(.indexOf v "foo")

;; get a value by index
(nth '(a b c) 1)


;===========================
; 5 What Now?
;===========================

;; Some 4clojure test to sharpen my skills with these concepts would be nice.
;; http://www.4clojure.com/problems


;=======================================================
;=======================================================
; Core Functions in Depth
;=======================================================
;=======================================================
