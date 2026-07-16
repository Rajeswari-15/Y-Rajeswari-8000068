import React from "react";

function BookDetails() {

    const books = [
        { id: 1, title: "Java Programming", author: "James Gosling" },
        { id: 2, title: "React JS", author: "Jordan Walke" },
        { id: 3, title: "Python Basics", author: "Guido van Rossum" }
    ];

    return (
        <div>
            <h2>Book Details</h2>

            <ul>
                {books.map(book => (
                    <li key={book.id}>
                        <b>{book.title}</b> - {book.author}
                    </li>
                ))}
            </ul>

        </div>
    );
}

export default BookDetails;