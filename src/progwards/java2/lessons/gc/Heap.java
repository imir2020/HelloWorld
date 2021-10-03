package progwards.java2.lessons.gc;

public class Heap {
    int maxheapSize;
    byte[] bytes;// - собственно, куча
    public Heap(int maxheapSize) {
        this.maxheapSize = maxheapSize;
    }
// - "размещает", т.е. помечает как занятый блок памяти с количеством ячеек массива heap равным size.
// Соответственно это должен быть непрерывный блок (последовательность ячеек),
// которые на момент выделения свободны. Возвращает "указатель" - индекс первой ячейки в массиве, размещенного блока.
    public int malloc(int size) {
        return 0;//временная мера
    }
// - "удаляет", т.е. помечает как свободный блок памяти по "указателю".
// Проверять валидность указателя - т.е. то, что он соответствует началу ранее выделенного блока,
// а не его середине, или вообще, уже свободному.
    public void free(int ptr) {

    }
//- осуществляет дефрагментацию кучи - ищет смежные свободные блоки,
// границы которых соприкасаются и которые можно слить в один.
    public void defrag() {

    }
// - компактизация кучи - перенос всех занятых блоков в начало хипа, с копированием самих данных - элементов массива.
// Для более точной имитации производительности копировать просто в цикле по одному элементу, не используя System.arraycopy.
// Обязательно запускаем compact из malloc если не нашли блок подходящего размера
    public void compact() {

    }
//Создать исключения
    //OutOfMemoryException
    //InvalidPointerException
public void getBytes(int ptr, byte[] bytes) {
    //System.arraycopy(this.bytes, ptr, bytes, 0, size);
}

    public void setBytes(int ptr, byte[] bytes) {
        //System.arraycopy(bytes, 0, this.bytes, ptr, size);
    }
    public static void main(String[] args) {

    }
}
