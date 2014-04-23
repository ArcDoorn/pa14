(ns pa14.solution.map)

(defmacro defmap [name & body]
  `(def ~name (-> {} ~@body)))

(defn room [map key text]
  (assoc map key {:desc text, :doors []}))

(defn add-door [room door-key]
  (let [doors (conj (:doors room) door-key)]
    (assoc room :doors doors)))

(defn link [map key1 names1 key2 names2]
  (let [door-key1 (gensym)
        door-key2 (gensym)
        door1 {:desc "a door", :conter-part door-key2, :target key2}
        door2 {:desc "a door", :conter-part door-key1, :target key1}
        room1 (add-door (get map key1) names1)
        room2 (add-door (get map key2) names2)]
    (assoc map
      key1 room1
      key2 room2
      door-key1 door1
      door-key2 door2)))

(def east ["e", "east"])
(def west ["w", "west"])

(defmap my-flat
  (room :entrance-room
        "This is a small room with the main door to the south a
door labeled 'WC' to the west, and two other dors to the north and
the east.")
  (room :living-room
    "A room with a big sofa, a table, a desk. There is an exit to the balcony in the north east and a door each to the south west and the north west.")
  (link :entrance-room east
        :living-room west))

