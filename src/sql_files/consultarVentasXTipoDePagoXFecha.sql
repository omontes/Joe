select sum(ProdCant.PrecioVenta) as Precio
from productocantidadfact as ProdCant  
inner join factura as F on ProdCant.idFactura=F.idFactura 
where F.TipoPago=? and F.Fecha  between ? and ?;
