import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchProducts } from "../slice/HomeSlice";

export default function Products() {
  const dispatch = useDispatch();
  const { items, isLoading, isError, message } = useSelector(
    (state) => state.products
  );

  useEffect(() => {
    dispatch(fetchProducts());
  }, [dispatch]);

  if (isLoading)
    return <div className="text-center text-lg font-semibold mt-10">Carregando...</div>;

  if (isError)
    return (
      <div className="text-red-500 text-center mt-10">
        Erro ao carregar produtos: {message}
      </div>
    );

  return (
    <div className="p-8">
      <h1 className="text-3xl font-bold mb-6 text-gray-800">
        Lista de Produtos
      </h1>

      <div className="overflow-x-auto">
        <table className="min-w-full bg-white border border-gray-300 rounded-lg shadow-lg">
          <thead>
            <tr className="bg-gray-100 text-gray-700">
              <th className="py-3 px-4 text-left">Código</th>
              <th className="py-3 px-4 text-left">Nome</th>
              <th className="py-3 px-4 text-left">Quantidade</th>
              <th className="py-3 px-4 text-left">Categoria</th>
              <th className="py-3 px-4 text-left">Criado em</th>
              <th className="py-3 px-4 text-left">Atualizado em</th>
            </tr>
          </thead>
          <tbody>
            {items.map((product) => (
              <tr key={product.cod} className="border-t hover:bg-gray-50">
                <td className="py-2 px-4">{product.cod}</td>
                <td className="py-2 px-4">{product.name}</td>
                <td className="py-2 px-4">{product.quantity}</td>
                <td className="py-2 px-4">{product.categoryEnum}</td>
                <td className="py-2 px-4">
                  {new Date(product.createDateTime).toLocaleString("pt-BR")}
                </td>
                <td className="py-2 px-4">
                  {new Date(product.updatedDateTime).toLocaleString("pt-BR")}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
