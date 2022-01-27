package operation;

import book.Book;
import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * User: 12629
 * Date: 2021/11/15
 * Time: 19:56
 * Description:
 */
public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
        System.out.println("请输入你要归还的图书的名字：");
        String name = scanner.nextLine();
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            Book book = bookList.getPos(i);
            if(name.equals(book.getName())) {
                book.setBorrowed(false);
                System.out.println("归还成功！");
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有你要归还的这本书！");
    }
}

