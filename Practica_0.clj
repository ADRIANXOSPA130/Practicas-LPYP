
(defn lista-n [n]
  "Esta Función toma un entero n y devuelve la lista de numeros que va de 1 a n
   primero se llama de forma recursiva aplicandose a si misma y usando dec se
   suma (-1) y al final con conj agrega n al final de la lista
   
   Params:
   - n: un entero
   
   Returns:
   - Una lista de la forma (1 2 3 . . . n)"
  (if (<= n 1)
    [1]
    (conj (lista-n (dec n)) n)))
(defn multiplo-3-5 [n]
  "Esta función revisa si un entero n es multiplo de 3, 5 o de ambos, esto 
   con mod que revisa si un numero es modulo de otro y si lo es devuelve 0, primero 
   usando un if revisa si es multiplo de ambos, en caso de serlo le asigna FB,
   si no se cumple revisa que sea multiplo unicamente de 5, en caso de serlo
   le asigna B, si no lo cumple revisa que sea multiplo de 3, si lo es le asigna
   F y si no se cumple ninguno de estos if solo regresa el entero n
   
   Params:
   - n: un entero
   
   Returns:
   - FB si es multiplo de 5 y 3 
   - F si es multiplo de 3
   - B si es multiplo de 5
   - n si no es multiplo de 3 ni 5"
  (if (= (+ (mod n 5) (mod n 3)) 0)
    (str "FB")
    (if (= (mod n 5) 0)
      (str "B")
      (if (= (mod n 3) 0)
        (str "F")
        (int n)))))
(defn fizz-buzz [n]
  "La función toma un entero n y le aplica la función anterior
   lista-n para crear una lista de numeros de 1 a n, despues con map
   aplica a cada elemnto de la lista la función multiplo-3-5 para devolver 
   una lista de la siguiente forma (1 2 F 4 B . . 13 14 FB . . n)
   
   Params:
   - n: un entero
   
   Returns:
   - Regresa una lista donde lo numeros multiplo de 3 y 5 se cambian por FB, los
   multiplos de 5 por B, los multiplos de 3 por F y los demas se quedan igual"
  (map multiplo-3-5 (lista-n n)))



(defn lista-c [n]
  "La función toma un entero n, primero usa un if para ver si es igual a 1, si
  lo es unicamente va a devolver una lista con el 1, cuando no sea asi primero 
  usa otro if, si n es par, que esto lo sabemos viendo que mod de n con 2 sea 
  igual a 0, entonces divide n entre 2 y usa cons para agregar n/2 a una lista
  y despues a n/2 le vuelve a aplicar la función lista-c y asi de forma recursiva 
  hasta llegar a 1, cuando n es impar entonces multiplica n*3 y le suma uno al 
  resultado, despues agreega 3n+1 a una lista y sigue asi de manera recursiva 
  hasta llegar a 1, al final de cualquiera de estos casos agrega la n original 
  con cons al principio de la lista
  
  Params:
   - n: un entero
   
   Returns:
   - Una lista que aplica la Conjetura de Collatz"
  (if (= n 1)
    [1]
    (cons n (lista-c (if (= (mod n 2) 0)
                       (/ n 2)
                       (+ (* n 3) 1))))))



(defn suma [a b]
  "La función resive dos enteros a y b, primero revisa si a es igual a 0, si 
   es así unicamente regresa b, de no ser asi revisa si b es igual a 0, cuando
   esto pasa unicamente regresa a y si ambos numeros son distintos de 0, con la
   función repeat crea una lista con una cantidad a de a's y tambien crea una 
   lista con una cantidad b de b's, despues con concat las concatena y juta ambas
   listas, por ultimo con count cuenta la cantidad de elemntos en la lista
   y te devuelve el numero de estos
   
   Params:
   - a: un entero
   - b: un entero
   
   Returns:
   - La suma de a y b"
  (if (= a 0)
    (int b)
    (if (= b 0)
      (int a)
      (count (concat (repeat a :a) (repeat b :b))))))



(defn pares? [lst]
  "La función toma una lista de numeros y primero con un if usa el predicado
   empty? el cual revisa si la lista esta vacia, en caso de estarla devuelve 
   un true, si la lista tiene al menos un elemento entonces pasa al siguiente
   if el cual toma el primer elemento de la lista y revisa si es multiplo de 2
   y por lo tanto par usando mod para que si el resltado es igual a 0 entonces
   vuelva a aplicar el la funcón al resto de la lista y si todos los numeros 
   son pares entonces devolver true, si cualquier numero de la lista es impar
   entonces devuelve un false
   
   Params:
   - lst: una lista de numeros enteros 
   
   Returns:
   - true: si la lista solo tiene numeros pares
   - false: si la lista tiene algun numero impar"
  (if (empty? lst)
    true
    (if (= (mod (first lst) 2) 0)
      (pares? (rest lst))
      false)))











