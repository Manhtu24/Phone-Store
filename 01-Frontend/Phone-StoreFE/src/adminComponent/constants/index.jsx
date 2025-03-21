import {
  ChartColumn,
  Home,
  Package,
  Users,
  LogOut,
  UserPen,
  Banknote,
  ShoppingCart,
  NotebookPen,
  Logs,AlignJustify,Trello,PictureInPicture2
} from "lucide-react";
import { assets } from "../../assets/images/images";

export const navbarLinks = [
  {
    title: "Dashboard",
    links: [
      {
        label: "Dashboard",
        icon: Home,
        path: "/admin/dashboard",
      },
      {
        label: "Doanh thu",
        icon: ChartColumn,
        path: "admin/analytics",
      },
    ],
  },
  {
    title:"Categories",
    links:[
      {
        label:"Thương hiệu",
        icon:Trello,
        path:"/admin/voucher"
      },
      {
        label:"Danh mục cha",
        icon:Logs,
        path:"/admin/voucher"
      },
      {
        label:"Danh mục con",
        icon:AlignJustify,
        path:"/admin/voucher"
      },
    ]
  },
  {
    title: "Customers",
    links: [
      {
        label: "Người dùng",
        icon: Users,
        path: "/admin/customers",
      },
      // {
      //   label: "New customer",
      //   icon: UserPlus,
      //   path: "/new-customer",
      // },
      // {
      //   label: "Verified customers",
      //   icon: UserCheck,
      //   path: "/verified-customers",
      // },
    ],
  },
  {
    title: "Products",
    links: [
      {
        label: "Sản phẩm",
        icon: Package,
        path: "/products",
      },
      // {
      //   label: "New product",
      //   icon: PackagePlus,
      //   path: "/new-product",
      // },
      // {
      //   label: "Inventory",
      //   icon: ShoppingBag,
      //   path: "/inventory",
      // },
    ],
  },
  {
    title:"Promotion",
    links:[
      {
        label:"Voucher",
        icon:Banknote,
        path:"/admin/voucher"
      },
    ]
  },
  {
    title:"Orders",
    links:[
      {
        label:"Đơn hàng",
        icon:ShoppingCart,
        path:"/admin/orders"
      },
    ]
  },
  {
    title:"Banner",
    links:[
      {
        label:"Banner",
        icon:PictureInPicture2,
        path:"/admin/banners"
      },
    ]
  },
  {
    title:"Blogs",
    links:[
      {
        label:"Bài viết",
        icon:NotebookPen,
        path:"/admin/orders"
      },
    ]
  },
  {
    title: "Account",
    links: [
      {
        label: "Đổi mật khẩu",
        icon: UserPen,
        path: "/change-password",
      },
      {
        label:"Đăng xuất",
        icon:LogOut,
        path:"/account/login"
      }
    ],
  },
];

export const overviewData = [
  {
    name: "Jan",
    total: 1500,
  },
  {
    name: "Feb",
    total: 2000,
  },
  {
    name: "Mar",
    total: 1000,
  },
  {
    name: "Apr",
    total: 5000,
  },
  {
    name: "May",
    total: 2000,
  },
  {
    name: "Jun",
    total: 5900,
  },
  {
    name: "Jul",
    total: 2000,
  },
  {
    name: "Aug",
    total: 5500,
  },
  {
    name: "Sep",
    total: 2000,
  },
  {
    name: "Oct",
    total: 4000,
  },
  {
    name: "Nov",
    total: 1500,
  },
  {
    name: "Dec",
    total: 2500,
  },
];

export const recentSalesData = [
  {
    id: 1,
    name: "Olivia Martin",
    email: "olivia.martin@email.com",
    image: assets.Google,
    total: 1500,
  },
  {
    id: 2,
    name: "James Smith",
    email: "james.smith@email.com",
    image: assets.Google,
    total: 2000,
  },
  {
    id: 3,
    name: "Sophia Brown",
    email: "sophia.brown@email.com",
    image: assets.Google,
    total: 4000,
  },
  {
    id: 4,
    name: "Noah Wilson",
    email: "noah.wilson@email.com",
    image: assets.Google,
    total: 3000,
  },
  {
    id: 5,
    name: "Emma Jones",
    email: "emma.jones@email.com",
    image: assets.Google,
    total: 2500,
  },
  {
    id: 6,
    name: "William Taylor",
    email: "william.taylor@email.com",
    image: assets.Google,
    total: 4500,
  },
  {
    id: 7,
    name: "Isabella Johnson",
    email: "isabella.johnson@email.com",
    image: assets.Google,
    total: 5300,
  },
];

export const topProducts = [
  {
    number: 1,
    name: "Wireless Headphones",
    image: assets.Google,
    description: "High-quality noise-canceling wireless headphones.",
    price: 99.99,
    status: "In Stock",
    rating: 4.5,
  },
  {
    number: 2,
    name: "Smartphone",
    image: assets.Google,
    description: "Latest 5G smartphone with excellent camera features.",
    price: 799.99,
    status: "In Stock",
    rating: 4.7,
  },
  {
    number: 3,
    name: "Gaming Laptop",
    image: assets.Google,
    description: "Powerful gaming laptop with high-end graphics.",
    price: 1299.99,
    status: "In Stock",
    rating: 4.8,
  },
  {
    number: 4,
    name: "Smartwatch",
    image: assets.Google,
    description: "Stylish smartwatch with fitness tracking features.",
    price: 199.99,
    status: "Out of Stock",
    rating: 4.4,
  },
  {
    number: 5,
    name: "Bluetooth Speaker",
    image: assets.Google,
    description: "Portable Bluetooth speaker with deep bass sound.",
    price: 59.99,
    status: "In Stock",
    rating: 4.3,
  },
  {
    number: 6,
    name: "4K Monitor",
    image: assets.Google,
    description: "Ultra HD 4K monitor with stunning color accuracy.",
    price: 399.99,
    status: "In Stock",
    rating: 4.6,
  },
  {
    number: 7,
    name: "Mechanical Keyboard",
    image: assets.Google,
    description: "Mechanical keyboard with customizable RGB lighting.",
    price: 89.99,
    status: "In Stock",
    rating: 4.7,
  },
  {
    number: 8,
    name: "Wireless Mouse",
    image: assets.Google,
    description: "Ergonomic wireless mouse with precision tracking.",
    price: 49.99,
    status: "In Stock",
    rating: 4.5,
  },
  {
    number: 9,
    name: "Action Camera",
    image: assets.Google,
    description: "Waterproof action camera with 4K video recording.",
    price: 249.99,
    status: "In Stock",
    rating: 4.8,
  },
  {
    number: 10,
    name: "External Hard Drive",
    image: assets.Google,
    description: "Portable 2TB external hard drive for data storage.",
    price: 79.99,
    status: "Out of Stock",
    rating: 4.5,
  },
];
