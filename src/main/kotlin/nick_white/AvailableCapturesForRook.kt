package nick_white

fun main() {
    val boards = listOf(
        arrayOf(
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'p', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'R', '.', '.', '.', 'p'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'p', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.')
        ),
        arrayOf(
            charArrayOf('.','.','.','.','.','.','.','.'),
            charArrayOf('.','p','p','p','p','p','.','.'),
            charArrayOf('.','p','p','B','p','p','.','.'),
            charArrayOf('.','p','B','R','B','p','.','.'),
            charArrayOf('.','p','p','B','p','p','.','.'),
            charArrayOf('.','p','p','p','p','p','.','.'),
            charArrayOf('.','.','.','.','.','.','.','.'),
            charArrayOf('.','.','.','.','.','.','.','.')
        ),
        arrayOf(
            charArrayOf('.','.','.','.','.','.','.','.'),
            charArrayOf('.','.','.','p','.','.','.','.'),
            charArrayOf('.','.','.','p','.','.','.','.'),
            charArrayOf('p','p','.','R','.','p','B','.'),
            charArrayOf('.','.','.','.','.','.','.','.'),
            charArrayOf('.','.','.','B','.','.','.','.'),
            charArrayOf('.','.','.','p','.','.','.','.'),
            charArrayOf('.','.','.','.','.','.','.','.')
        )
    )
    for (board in boards) {
        println("pawns captured: ${available_captures_for_rook_nick(board)}")
    }
}

fun available_captures_for_rook_nick(board: Array<CharArray>): Int {
    var rookX = 0
    var rookY = 0
    // find where rook is located on board
    for (x in 0..7) {
        for (y in 0..7) {
            if (board[x][y] == 'R') {
                rookX = x
                rookY = y
                break
            }
        }
    }
    var count = 0
    // starting from rook's location, fan out horizontally and vertically
    // if a white bishop is found, stop
    // if a black pawn is found, keep count
    for (x in rookX downTo 0) {
        if (board[x][rookY] == 'B') {
            break
        } else if (board[x][rookY] == 'p') {
            count++
            break
        }
    }
    for (x in rookX..7) {
        if (board[x][rookY] == 'B') {
            break
        } else if (board[x][rookY] == 'p') {
            count++
            break
        }
    }
    for (y in rookY downTo 0) {
        if (board[rookX][y] == 'B') {
            break
        } else if (board[rookX][y] == 'p') {
            count++
            break
        }
    }
    for (y in rookY..7) {
        if (board[rookX][y] == 'B') {
            break
        } else if (board[rookX][y] == 'p') {
            count++
            break
        }
    }
    return count
}

fun available_captures_for_rook(board: Array<CharArray>): Int {
    var rook = IntArray(2)
    val bishops = mutableListOf<IntArray>()
    val pawns = mutableListOf<IntArray>()
    val bishopRows = mutableMapOf<Int, MutableList<Int>>()
    val bishopColumns = mutableMapOf<Int, MutableList<Int>>()
    val pawnRows = mutableMapOf<Int, MutableList<Int>>()
    val pawnColumns = mutableMapOf<Int, MutableList<Int>>()
    for (i in board.indices) {
        for (j in board[i].indices) {
            when (board[i][j]) {
                'R' -> intArrayOf(i, j)
                'B' -> {
                    bishops.add(intArrayOf(i, j))
                    if (!bishopRows.containsKey(i)) // putIfAbsent() ??
                        bishopRows[i] = mutableListOf()
                    bishopRows[i]!!.add(j)
                    if (!bishopColumns.containsKey(j))
                        bishopColumns[j] = mutableListOf()
                    bishopColumns[j]!!.add(i)
                }

                'p' -> {
                    pawns.add(intArrayOf(i, j))
                    if (!pawnRows.containsKey(i))
                        pawnRows[i] = mutableListOf()
                    pawnRows[i]!!.add(j)
                    if (!pawnColumns.containsKey(j))
                        pawnColumns[j] = mutableListOf()
                    pawnColumns[j]!!.add(i)
                }
            }
        }
    }

    var count = 0
    val row = rook[0]
    if (pawnRows.containsKey(row)) {
        if (bishopRows.containsKey(row)) {
        }
    }
    // too complicated, I give up
    return 0
}