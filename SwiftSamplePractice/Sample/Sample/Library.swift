import Foundation
import UIKit

class Book {
    var title: String
    var author: String
    
    init(title: String, author: String) {
        self.title = title
        self.author = author
    }
}

class BookListViewController: UITableViewController {
    var books = [Book]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Initialize some sample books
        books.append(Book(title: "The Catcher in the Rye", author: "J.D. Salinger"))
        books.append(Book(title: "To Kill a Mockingbird", author: "Harper Lee"))
        books.append(Book(title: "1984", author: "George Orwell"))
        
        // Set up the table view
        tableView.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
    }
    
    // MARK: - Table view data source
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return books.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
        let book = books[indexPath.row]
        cell.textLabel?.text = "\(book.title) by \(book.author)"
        return cell
    }
    
    // MARK: - Actions
    
    @IBAction func addBook(_ sender: UIBarButtonItem) {
        let alert = UIAlertController(title: "Add Book", message: nil, preferredStyle: .alert)
        
        alert.addTextField { textField in
            textField.placeholder = "Title"
        }
        
        alert.addTextField { textField in
            textField.placeholder = "Author"
        }
        
        alert.addAction(UIAlertAction(title: "Cancel", style: .cancel, handler: nil))
        
        alert.addAction(UIAlertAction(title: "Save", style: .default) { [unowned self] _ in
            guard let title = alert.textFields?[0].text, let author = alert.textFields?[1].text else {
                return
            }
            
            let book = Book(title: title, author: author)
            self.books.append(book)
            self.tableView.reloadData()
        })
        
        present(alert, animated: true)
    }
    
    @IBAction func deleteBook(_ sender: UIBarButtonItem) {
        if let selectedIndexPaths = tableView.indexPathsForSelectedRows {
            let indicesToDelete = selectedIndexPaths.map { $0.row }.sorted().reversed()
            indicesToDelete.forEach { books.remove(at: $0) }
            tableView.deleteRows(at: selectedIndexPaths, with: .automatic)
        }
    }
}

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    var window: UIWindow?
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        window = UIWindow(frame: UIScreen.main.bounds)
        window?.rootViewController = UINavigationController(rootViewController: BookListViewController())
        window?.makeKeyAndVisible()
        return true
    }
}
