/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio.filevisitor;

import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/*
/**
     * Continue. When returned from a {@link FileVisitor#preVisitDirectory
     * preVisitDirectory} method then the entries in the directory should also
     * be visited.
     *
    CONTINUE,
    /**
     * Terminate.
     *
    TERMINATE,
    /**
     * Continue without visiting the entries in this directory. This result
     * is only meaningful when returned from the {@link
     * FileVisitor#preVisitDirectory preVisitDirectory} method; otherwise
     * this result type is the same as returning {@link #CONTINUE}.
     *
    SKIP_SUBTREE,       !!!!!!!!!!!!!!!!!!!!
    /*
     * Continue without visiting the <em>siblings</em> of this file or directory.
     * If returned from the {@link FileVisitor#preVisitDirectory
     * preVisitDirectory} method then the entries in the directory are also
     * skipped and the {@link FileVisitor#postVisitDirectory postVisitDirectory}
     * method is not invoked.
     *
    SKIP_SIBLINGS;
    
========================== From Files.walkFileTree =============================    
    
*********************************
    result = visitor.preVisitDirectory(ev.file(), ev.attributes());
    // if SKIP_SIBLINGS and SKIP_SUBTREE is returned then
    // there shouldn't be any more events for the current
    // directory.
    if (result == FileVisitResult.SKIP_SUBTREE ||
        result == FileVisitResult.SKIP_SIBLINGS)
        walker.pop();
        
*********************************
        result = visitor.postVisitDirectory(ev.file(), ev.ioeException());
        // SKIP_SIBLINGS is a no-op for postVisitDirectory
        if (result == FileVisitResult.SKIP_SIBLINGS) result = FileVisitResult.CONTINUE;


*********************************
*if (Objects.requireNonNull(result) != FileVisitResult.CONTINUE) {
    if (result == FileVisitResult.TERMINATE) {
        break;              !!!!!!!!!!!!!!!!!!!!
    } else if (result == FileVisitResult.SKIP_SIBLINGS) {
        walker.skipRemainingSiblings();
    }
}

 */
/**
 * @author Алексей
 *
 */
public class FileVisitorBasic extends SimpleFileVisitor<Path> {

    /*
     * (non-Javadoc)
     * 
     * @see java.nio.file.SimpleFileVisitor#visitFile(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path path = Paths.get(insertHome());
        if (file.startsWith(path)) {
            System.out.println(String.format("file name:%s", file.getFileName().toString()));
        }
        if (file.getFileName().endsWith("fileX2.txt")) {

            // return FileVisitResult.SKIP_SIBLINGS;
        }
        return FileVisitResult.CONTINUE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.nio.file.SimpleFileVisitor#preVisitDirectory(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
     */
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(String.format("pre visit dir:%s", dir.getFileName().toString()));
        if (dir.endsWith("y")) {
            // if returned by preVisitDirectory, postVisitDirectory won't be called
            // parent elements will be walked through
            // Skip all entries in "y"
            // return FileVisitResult.SKIP_SIBLINGS;
        }
        if (dir.endsWith("y")) {
            // For preVisitDir the same as SKIP_SIBLINGS
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.nio.file.SimpleFileVisitor#postVisitDirectory(java.lang.Object, java.io.IOException)
     */
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println(String.format("post visit dir:%s", dir.getFileName().toString()));
        if (dir.endsWith("x")) {
            // In this case like CONTINUE
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.nio.file.SimpleFileVisitor#visitFileFailed(java.lang.Object, java.io.IOException)
     */
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }

    public static void main(String args[]) throws IOException {
        FileVisitorBasic fvb = new FileVisitorBasic();
        Path path = Paths.get(insertHome() + "\\x");
        printDir(path);
        Files.walkFileTree(path, fvb);

    }

    public static void printDir(Path path) throws IOException {
        System.out.println(String.format("=====  Start %s  ==============", path.toString()));
        recursivePrint(path);
        System.out.println(String.format("======= END  %s  ==============", path.toString()));
    }

    private static void recursivePrint(Path path) throws IOException {
        DirectoryStream<Path> ds = Files.newDirectoryStream(path);
        for (Path p : ds) {
            if (Files.isDirectory(p)) {
                recursivePrint(p);
            }
            System.out.println(relativeFromHome(p).toString());
        }
    }

    public static Path relativeFromHome(Path path) {
        return Paths.get(insertHome()).relativize(path);
    }

}
