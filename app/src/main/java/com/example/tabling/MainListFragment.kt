package com.example.tabling

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tabling.databinding.FragmentListBinding
import com.example.tabling.model.ListItem
import com.example.tabling.vm.ListItemViewModel
import com.example.tabling.widget.RecyclerViewItemClickListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainListFragment : Fragment(), RecyclerViewItemClickListener {
    private lateinit var vm: ListItemViewModel
    lateinit var adapter: ItemListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        vm = ViewModelProvider(this).get(ListItemViewModel::class.java)
        adapter = ItemListAdapter(this)
        binding.viewModel = vm
        binding.lifecycleOwner = this
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        vm.getListItemRx().subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                adapter.submitList(it)

            }, {
            }

            )
//        vm.getListItem().observe(viewLifecycleOwner, Observer {
//            adapter.submitList(it)
//        })

        return binding.root
    }

    override fun onItemClick(item: ListItem) {

        val detailIntent = Intent(requireContext(), DetailActivity::class.java)
        detailIntent.putExtra("imageUrl", item.downloadUrl)
        startActivity(detailIntent)
    }

}