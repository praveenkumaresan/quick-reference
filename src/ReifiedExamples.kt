import java.lang.RuntimeException

@OptIn(ExperimentalStdlibApi::class)
fun main(){
    val books = listOf(
        Fiction("Moby Dick"),
        NonFiction("Learn to Code"),
        Fiction("LOTR")
    )

    println(findFirst<NonFiction>(books = books).name)
    println(findFirst(books = books, NonFiction::class.java).name)
}

abstract class Book(val name: String)

class Fiction(name: String) : Book(name)
class NonFiction(name: String): Book(name)

//types - find first book using generics
fun <T> findFirst(books: List<Book>, ofClass: Class<T>): T {
    val selected = books.filter { book -> ofClass.isInstance(book) }

    if (selected.isEmpty()){
        throw RuntimeException("Not found")
    }

    return ofClass.cast(selected[0])
}

//types - reified types.kt
inline fun <reified T> findFirst(books: List<Book>) : T {
    val selected = books.filter { book -> book is T }
    if (selected.isEmpty()){
        throw RuntimeException("Not found")
    }
    return selected[0] as T
}